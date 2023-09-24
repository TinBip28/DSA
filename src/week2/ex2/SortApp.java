package week2.ex2;

import java.util.Arrays;
import java.util.Random;

public class SortApp {
    public static void main(String[] args) {
        Random random = new Random();
        Integer[] integers = new Integer[random.nextInt(100)];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = random.nextInt(1_000);
        }
        String[] strings = new String[random.nextInt(100)];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = createRandomString(random,"ABCabc",7);
        }

        SortStrategy sortStrategy = SortStrategy.getInstance();
        ISort quick = new QuickSort();
        sortStrategy.setSortee(quick);
        sortStrategy.sort(strings);
        System.out.println(Arrays.toString(strings));

    }

    public static String createRandomString(Random random, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }

}
