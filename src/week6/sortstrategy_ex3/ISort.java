package week6.sortstrategy_ex3;

public interface ISort {
    void sort(int[] arr);

    int getSwapCount();

    long getTimes();

    int getCompareNums();
}
