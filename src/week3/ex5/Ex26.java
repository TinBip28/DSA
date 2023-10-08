package week3.ex5;

import java.util.LinkedList;
import java.util.Scanner;

public class Ex26 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(input.nextInt());
        }
        int k = input.nextInt();
        int value = list.get(k);
        for (int i = 0; i < n; i++) {
            if (list.get(i) > value) {
                list.remove(i);
                n--;
                i--;
            }
        }
        for (Integer i : list) {
            System.out.print(list.get(i) + " ");
        }
    }
}