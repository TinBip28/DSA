package week1.hw1_ex2;

import java.util.*;

public class genericArray<T> {
    private final T[] arr;
    public genericArray(T[] arr) {
        this.arr = arr;
    }

    //Tìm các phần tử trong mảng là số hoàn hảo mà không bị trùng lặp được sắp xếp theo giá trị tăng dần
    Set<Integer> getPerfectElements() {
        Set<Integer> res = new HashSet<>();
        for (T i : arr) {
            if (i instanceof Integer) {
                int val = (int) i;
                if (isPerfectNumber(val)) {
                    res.add(val);
                }
            }
        }
        return res;
    }

    public Set<Integer> getPrimeElements() {
        Set<Integer> res = new HashSet<>();
        for (T i : arr) {
            if (i instanceof Integer) {
                int val = (int) i;
                if (isPrime(val)) {
                    res.add(val);
                }
            }
        }
        return res;
    }

    Set<Integer> getSquareElements() {
        Set<Integer> res = new HashSet<>();
        for (T i : arr) {
            if (i instanceof Integer) {
                int val = (int) i;
                if (isSquare(val)) {
                    res.add(val);
                }
            }
        }
        return res;
    }


    private boolean isPerfectNumber(int number) {
        if (number == 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    private boolean isSquare(int number) {
        if (number > 0) {
            int res = (int) Math.sqrt(number);
            return ((res * res == number));
        }
        return false;
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
