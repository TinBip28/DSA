package week3.ex10;

import java.util.Scanner;

public class ReversedLinkedList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
       SimpleLinkedList list = new SimpleLinkedList();
        for (int i = 0; i < n; i++) {
            list.addBot(input.nextInt());
        }
        list.print();
        list.reverseList();
        list.print();
    }
}
