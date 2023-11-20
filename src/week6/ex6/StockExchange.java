package week6.ex6;

import java.util.PriorityQueue;

public class StockExchange {
    private final PriorityQueue<Stock> sell;
    private final PriorityQueue<Stock> buy;

    public StockExchange() {
        this.sell = new PriorityQueue<>((a, b) -> b.getPrice() - a.getPrice());
        this.buy = new PriorityQueue<>((a, b) -> b.getPrice() - a.getPrice());
    }

    public void typeOf(Stock stock) {
        switch (stock.getType().toLowerCase()) {
            case "buy" -> buy.add(stock);
            case "sell" -> sell.add(stock);
            default -> System.out.println("Invalid");
        }
    }

    public void execute() {
        while (!buy.isEmpty() && sell != null) {
            Stock buyOrder = buy.poll();
            Stock sellOrder = sell.poll();
            assert buyOrder != null;
            assert sellOrder != null;
            if (Integer.compare(buyOrder.getTotal(), sellOrder.getTotal()) >= 1) {
                System.out.println("Stock Exchange - Buy: " + buyOrder.getCopany() + ", Sell: " + sellOrder.getCopany());
                System.out.println();
            } else {
                buy.offer(buyOrder);
                sell.offer(sellOrder);
            }
        }

    }

    public static void main(String[] args) {
        StockExchange tradingSystem = new StockExchange();
        tradingSystem.typeOf(new Stock("buy", 100, 100, "TH True Milk"));
        tradingSystem.typeOf(new Stock("buy", 75, 125, "Vingroup"));
        tradingSystem.typeOf(new Stock("sell", 20, 150, "Vinamilk"));
        tradingSystem.typeOf(new Stock("sell", 80, 70, "FLC Group"));
        tradingSystem.typeOf(new Stock("sell", 65, 60, "ACB"));
        tradingSystem.execute();
    }
}
