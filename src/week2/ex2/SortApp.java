package week2.ex2;

import week1.hw1_ex2.Main;

import java.util.Arrays;
import java.util.Random;

public class SortApp {
    public static void main(String[] args) {
        Random random = new Random();
        Integer[] integers = new Integer[random.nextInt(1,100)];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = random.nextInt(1_000);
        }
        String[] strings = new String[random.nextInt(1,100)];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = createRandomString(random, "ABCabcZXy", 7);
        }
        Double[] doubles = new Double[random.nextInt(1,100)];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = random.nextDouble(1,100);
            doubles[i] = (double) Math.round(doubles[i] * 100) / 100;

        }

        SortStrategy sortStrategy = SortStrategy.getInstance();
        ISort quick = new QuickSort();
        sortStrategy.setSortee(quick);
        sortStrategy.sort(strings);
        System.out.println(Arrays.toString(strings));

        ISort merge = new MergeSort();
        sortStrategy.setSortee(merge);
        sortStrategy.sort(doubles);
        System.out.println(Arrays.toString(doubles));

        ISort select = new SelectionSort();
        sortStrategy.setSortee(select);
        sortStrategy.sort(integers);
        System.out.println(Arrays.toString(integers));
    }

    public static String createRandomString(Random random, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }

}
