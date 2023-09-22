package week2.ex4.lesson_50;

import java.util.*;

public class SquareElements {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] data = createData();
        QuickSort sort = new QuickSort();
        sort.quickSort(data, 0, data.length - 1);
        runAndCheckData(data);
        runAndCheckData2(data);
    }

    public static int[] createData() {
        int n = input.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = input.nextInt();
        }
        return data;
    }

    public static boolean isSquare(int number) {
        if (number >= 0) {
            int n = (int) Math.sqrt(number);
            return n * n - number == 0;
        }
        return false;
    }

    public static void runAndCheckData(int[] data) {
        int count = 0;
        if (isSquare(data[0])) {
            System.out.print(data[0] + " ");
            count++;
        }
        for (int i = 1; i < data.length; i++) {
            if (isSquare(data[i]) && data[i] != data[i - 1]) {
                System.out.print(data[i] + " ");
                count++;
            }
        }
        if (count == 0) System.out.println("NULL");
    }

    public static void runAndCheckData2(int[] data) {
        int count = 0;
        Set<Integer> list = new HashSet<>();
        for (int i : data) {
            if (isSquare(i)) {
                list.add(i);
                count++;
            }
        }
        if (count == 0) System.out.println("NULL");
        else System.out.println(list.toString().replace(",",""));
    }
}
