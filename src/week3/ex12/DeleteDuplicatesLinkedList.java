package week3.ex12;

import java.util.Scanner;

public class DeleteDuplicatesLinkedList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SimpleLinkedList list = new SimpleLinkedList();
        for (int i = 0; i < n; i++) {
            list.addBot(input.nextInt());
        }
        list.print();
        list.deleteDuplicates();
        list.print();
    }
}
