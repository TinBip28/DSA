package week2.sortstrategy;

public interface ISort {
    void sort(int[] arr);

    int getSwapCount();

    long getTimes();

    int getCompareNums();
}
