package week2.ex5;

import java.util.Arrays;
import java.util.Scanner;

public class NonDescSort {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        long[] data =  createData();
        QuickSort sort = new QuickSort();
        sort.quickSort(data,0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    public static long[] createData() {
        int n = input.nextInt();
        long[] data = new long[n];
        for (int i = 0; i < n; i++) {
            data[i] = input.nextLong();
        }
        return data;
    }
}
