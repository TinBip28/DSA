package week3.ex5;

import java.util.LinkedList;
import java.util.Scanner;

public class Ex30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int k = sc.nextInt();
        for (int i = k; i < n; i++) {
            System.out.print(list.get(i) + " ");
        }
        for (int i = 0; i < k; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
