package week7.ex1;

import java.util.Random;

public class TestArrayList {
    public static void main(String[] args) {
        Random random = new Random();
        UnSortedArrayList<Integer> integers = new UnSortedArrayList<>();
        SortedArrayList<Integer> integers1 = new SortedArrayList<>();
        int n = 10;
        for (int i = 0; i < n - 1; i++) {
            int val = random.nextInt(3, 999);
            integers.add(val);
            integers1.add(val);
        }
        integers.set(5, 100);
        integers.isContain(100);
        System.out.println(integers.binarySearch(100));
        System.out.println();


        System.out.println(integers1);
        integers1.add(100);
        integers1.isContain(100);
    }
}
