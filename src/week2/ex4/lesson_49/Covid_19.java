package week2.ex4.lesson_49;

import java.util.Scanner;

public class Covid_19 {
    public static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        int[] data = createData();
        QuickSort sort = new QuickSort();
        sort.quickSort(data,0, data.length - 1);
        System.out.println("Nhap khoang cach");
        int target = input.nextInt();
        int res = result(data, target);
        System.out.println(res);
    }

    public static int[] createData() {
        System.out.print("Nhap so luong phan tu ");
        int n = input.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = input.nextInt();
        }
        return data;
    }

    public static int result(int[] data, int target) {
        int count = 1;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i + 1] - data[i] > target)
                count++;
        }
        return count;
    }
}
