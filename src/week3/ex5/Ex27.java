package week3.ex5;

import java.util.LinkedList;
import java.util.Scanner;

public class Ex27 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
       SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        for (int i = n; i >= 1; i--) {
            list.add(i);
        }
        for (int j = 2; j <= n; j++) {
            list.add(j);
        }
        list.print();
    }
}
