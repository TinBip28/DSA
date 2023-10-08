package week3.ex9;

import java.util.Scanner;

public class Occurence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SimpleLinkedList list = new SimpleLinkedList();
        for (int i = 0; i < n; i++) {
            list.addBot(input.nextInt());
        }
        list.print();
        int count = 0;
        int value = input.nextInt();
        for (int i = 0; i < n; i++) {
            if (list.get(i) == value) count ++;
        }
        System.out.println(count);
    }
}
