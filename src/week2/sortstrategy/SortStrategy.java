package week2.sortstrategy;

public class SortStrategy {
    private static SortStrategy instance;
    private ISort sortee;



    private SortStrategy() {

    }

    public static SortStrategy getInstance() {
        if (instance == null) {
            instance = new SortStrategy();
        }
        return instance;
    }

    public void setSortee(ISort sortee) {
        this.sortee = sortee;
    }

    public void sort(int[] data) {
        sortee.sort(data);
    }
    public void getSwapNums() {
        System.out.println("SwapCount: " + sortee.getSwapCount());
    }

    public void getCompareNums() {
        System.out.println("CompareCount: " + sortee.getCompareNums());
    }

    public void getTimes() {
        System.out.println("Times: " + sortee.getTimes());
    }
    
}
