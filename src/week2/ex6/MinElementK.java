package week2.ex6;

import week2.ex5.QuickSort;

import java.util.Scanner;

public class MinElementK {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        long[] data = createData();
        QuickSort sort = new QuickSort();
        sort.quickSort(data, 0, data.length - 1);
        findMinIndex(data);
    }

    public static long[] createData() {
        int n = input.nextInt();
        long[] data = new long[n];
        for (int i = 0; i < n; i++) {
            data[i] = input.nextLong();
        }
        return data;
    }

    public static void findMinIndex(long[] data) {
        int k = input.nextInt();
        try {
            System.out.println(data[k]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of index or invalid index");
        }
    }
}
