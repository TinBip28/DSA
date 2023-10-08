package week3.ex8;

import java.util.Scanner;

public class NthNodeEndFrom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        for (int i = 0; i < n; i++) {
            list.addBot(scanner.nextInt());
        }
        int m = scanner.nextInt();
        System.out.println(list.getNthFromLast(m));
    }
}
