package week1.hw1_ex2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {

        System.out.print("Nhap kich thuoc cua mang: ");
        int n = input.nextInt();
        Integer[] data = createRandomIntArr(n);
        String[] data1 = new String[]{"DSA", "HUS", "VNU"};
        Double[] data2 = new Double[]{1.2, 2.3, 3.4};
        Object[] data3 = new Object[]{1, "abc", 'x', 1.f, 2};

        System.out.println("Du lieu trong mang");
        arrayToString(data);

        genericArray<Integer> array = new genericArray<>(data);
        System.out.println("Cac phan tu la so nguyen to trong mang");
        System.out.println(array.getPrimeElements());

        System.out.println("Cac phan tu la so hoan hao trong mang");
        System.out.println(array.getPerfectElements());

        System.out.println("Cac phan tu la so chinh phuong trong mang");
        System.out.println(array.getSquareElements());

        System.out.println("\nCac kieu mang chua du lieu khac");
        System.out.print("String: ");
        arrayToString(data1);
        System.out.print("Double: ");
        arrayToString(data2);
        System.out.print("Object: ");
        arrayToString(data3);
    }

    public static Integer[] createRandomIntArr(int length) {
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(1, 200);
        }
        return arr;
    }

    public static void arrayToString(Object[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
