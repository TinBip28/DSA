package week3.ex5;

import java.util.Scanner;

public class ex21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        for (int i = 0; i < n; i++) {
           list.addBot(input.nextInt());
        }
        for (int i = 0; i < n; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
