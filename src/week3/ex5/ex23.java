package week3.ex5;

import java.util.LinkedList;
import java.util.Scanner;

public class ex23 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(input.nextInt());
        }
        int k = input.nextInt();
        while (k < 0 || k >= n) {
            k = input.nextInt();
        }
        list.remove(k);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
