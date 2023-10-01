package week3.ex5;

import java.util.LinkedList;
import java.util.Scanner;

public class ex25 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(input.nextInt());
        }
        int a = input.nextInt();
        int b = input.nextInt();
        for (int i = 0; i < n; i++) {
            if (list.get(i) == a) list.set(i, b);
        }
        for (Integer j : list) {
            System.out.print(j + " ");
        }
    }
}
