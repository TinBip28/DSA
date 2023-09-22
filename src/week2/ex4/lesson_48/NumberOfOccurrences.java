package week2.ex4.lesson_48;

import java.util.*;

public class NumberOfOccurrences {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] data = createData();
        countElementsBySet(data);
    }

    public static int[] createData() {
        System.out.print("Nhap so luong phan tu ");
        int n = input.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = input.nextInt();
        }
        return data;
    }

    public static void countElementsByMap(int[] data) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int element : data) {
            map.put(element, 0);
        }
        for (int element : data) {
            if (map.containsKey(element)) {
                int count = map.get(element) + 1;
                map.put(element, count);
            } else {
                map.put(element, 1);
            }
        }
        for (Integer i : map.keySet()) {
            System.out.print(i + " " + map.get(i) + ";");
        }
    }

    public static void countElementsBySet(int[] data) {
        Set<Integer> list = new HashSet<>();
        for (int element : data) {
            list.add(element);
        }
        for (Integer i : list) {
            int count = 0;
            for (int datum : data) {
                if (i == datum) {
                    count++;
                }
            }
            System.out.print(i + " " + count + ";");
        }
    }
}
