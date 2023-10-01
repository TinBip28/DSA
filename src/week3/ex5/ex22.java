package week3.ex5;

import java.util.LinkedList;
import java.util.Scanner;

public class ex22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(input.nextInt());
        }
        int k = input.nextInt();
        int x = input.nextInt();
        while (k < 0 || k > n) {
            k = input.nextInt();
        }
        list.add(k, x);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
