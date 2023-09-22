package week2.ex7;


import week2.ex4.lesson_49.QuickSort;

import java.util.Scanner;

public class TwoSum {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] data = createData();
        int target = input.nextInt();
        excuteAndTime(data, target);

        QuickSort sort = new QuickSort();
        sort.quickSort(data, 0, data.length - 1);
        excuteAndTime(data,target);
    }

    public static int[] createData() {
        int n = input.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = input.nextInt();
        }
        return data;
    }

    public static int twoSum(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void excuteAndTime(int[] data, int target) {
        long start = System.nanoTime();
        System.out.println("Số cặp thỏa mãn: " + twoSum(data, target));
        long end = System.nanoTime();
        System.out.println("Thời gian thực hiện: " + (end - start));
    }
}
