package hw1_ex2;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Integer[] data = new Integer[]{1, 2, 3, 4, 5, 6};
        genericArray<Integer> array = new genericArray<>(data);
        Set primes = array.getPrimeElements();
        System.out.println(primes);
    }
}
