package week3.ex5;

import java.util.Scanner;

public class Ex25 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            list.addBot(input.nextInt());
        }
        int a = input.nextInt();
        int b = input.nextInt();
        for (int i = 0; i < n; i++) {
            if (list.get(i) == a) list.set(i, b);
        }
        list.print();
    }
}
