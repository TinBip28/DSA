package week1.hw1_ex3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Calculator {
    private static final Random random = new Random();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Input array length: ");
        int n = input.nextInt();

        System.out.print("Input calculation: ");
        String text = input.next();

        Complex[] arr1 = createArr(n);
        System.out.println("Array 1");
        printArrayComplex(arr1);
        Complex[] arr2 = createArr(n);
        System.out.println("Array 2");
        printArrayComplex(arr2);

        Complex[] res = calculator(arr1, arr2, text);
        System.out.println("arr1 " + text + " arr2");
        printArrayComplex(res);
    }

    private static Complex[] calculator(Complex[] arr1, Complex[] arr2, String type) {
        if (!equalLength(arr1.length, arr2.length)) {
            System.out.println("Length unequals");
        }
        Complex[] res = new Complex[arr1.length];
        switch (type) {
            case "+" -> {
                for (int i = 0; i < arr1.length; i++) {
                    res[i] = arr1[i].addComplex(arr2[i]);
                    res[i].setRound();
                }
            }
            case "-" -> {
                for (int i = 0; i < arr1.length; i++) {
                    res[i] = arr1[i].subtractComplex(arr2[i]);
                    res[i].setRound();
                }
            }
            case "*" -> {
                for (int i = 0; i < arr1.length; i++) {
                    res[i] = arr1[i].multiComplex(arr2[i]);
                    res[i].setRound();
                }
            }
        }
        return res;
    }

    private static boolean equalLength(int length1, int length2) {
        return length1 == length2;
    }

    private static Complex[] createArr(int length) {
        Complex[] arr = new Complex[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = createRandomComplex();
        }
        return arr;
    }

    private static Complex createRandomComplex() {
        double real = (double) Math.round(random.nextDouble(0, 10) * 10) / 10;
        double img = (double) Math.round(random.nextDouble(0, 10) * 10) / 10;
        return new Complex(real, img);
    }

    private static void printArrayComplex(Object[] arr) {
        System.out.println(Arrays.toString(arr).replaceAll(","," "));
    }
}
