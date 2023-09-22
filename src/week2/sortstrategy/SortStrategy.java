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

    public void sort(int[] data, int l, int r) {
        sortee.sort(data, l, r);
    }
}
