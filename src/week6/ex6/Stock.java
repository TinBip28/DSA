package week6.ex6;

public class Stock {
    private String type;
    private int quantity;
    private int price;
    private String copany;

    public Stock(String type, int quantity, int price, String copany) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.copany = copany;
    }

    public String getCopany() {
        return copany;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public int getTotal() {
        return price * quantity;
    }
}
