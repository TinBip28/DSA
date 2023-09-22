package week2.sortstrategy;

public class BubbleSort implements ISort {
    @Override
    public void sort(int[] data) {
        int n = data.length;
        int swapCount = 0;
        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                    swapCount++;
                }
            }
        }
        end = System.nanoTime();
        System.out.println(swapCount);
        System.out.println("Time :" + (end - start));
    }

    @Override
    public void sort(int[] data, int l, int r) {

    }


}