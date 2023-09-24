package week2.ex2;

public class SortStrategy {
    private ISort sortee;
    private static SortStrategy instance;

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

    public <T> void sort(T[] data) {
        sortee.sort(data);
    }
}
