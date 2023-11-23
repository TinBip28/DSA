package week7.ex1;

import java.util.Random;

public class TestArrayList {
    public static void main(String[] args) {
        Random random = new Random();
        UnSortedArrayList<Integer> integers = new UnSortedArrayList<>();
        SortedArrayList<Integer> integers1 = new SortedArrayList<>();
        int n = 49;
        for (int i = 0; i < n; i++) {
            int val = random.nextInt(3, 999);
            integers.add(val);
            integers1.add(val);
        }
        integers.add(50);
        System.out.println("Linear Search");
        integers.isContain(50);
        System.out.println();


        System.out.println(integers1);
        integers1.add(100);
        System.out.println("Binary Search");
        integers1.isContain(100);
    }
}
