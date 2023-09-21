package sortstrategy;

import java.util.Arrays;
import java.util.Random;

public class App {
    private static int[] randomIntArray() {
        Random random = new Random();
        int n = random.nextInt(10, 21);
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt(0, 100);
        }
        return data;
    }

    private static String ArrayToString(int[] data) {
        return Arrays.toString(data).replaceAll(",", "");
    }

    public static void main(String[] args) {
        int[] data = randomIntArray();
        SortStrategy sortStrategy = SortStrategy.getInstance();
        ISort bubbleSort = new BubbleSort();
        sortStrategy.setSortee(bubbleSort);
        sortStrategy.sort(data);
        System.out.println(ArrayToString(data));
    }
}
