package week3.ex5;

import java.util.LinkedList;
import java.util.Scanner;

public class Ex29 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.addBot(input.nextInt());
        }

        int k = input.nextInt();
        linkedList.removeByIndex(k);

        linkedList.print();
    }
}
