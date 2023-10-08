package week3.ex2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        SimpleArrayList<Integer> integers = new SimpleArrayList<>();
        int n = 10;
        for (int i = 0; i < n; i++) {
            integers.add(random.nextInt(3,209));
        }
        System.out.println(integers);
    }
}
