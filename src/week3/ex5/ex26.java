package week3.ex5;

import java.util.LinkedList;
import java.util.Scanner;

public class ex26 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(input.nextInt());
        }
        int k = input.nextInt();
        for (int i = 0; i < n; i++) {
            if (list.get(i) > list.get(k)) {
                list.remove(i);
                i--;
                n--;
            }
        }
        for (Integer j : list) {
            System.out.print(j + " ");
        }
    }
}