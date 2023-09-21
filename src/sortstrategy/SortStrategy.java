package sortstrategy;

public class SortStrategy {
    private static SortStrategy instance;
    private ISort sortee;

    private AdvancedISort adSortee;

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

    public SortStrategy(AdvancedISort adSortee) {
        this.adSortee = adSortee;
    }

    public void sort(int[] data) {
        sortee.sort(data);
    }

    public void sort(int[] data, int l, int r) {
        adSortee.sort(data, l, r);
    }
}
