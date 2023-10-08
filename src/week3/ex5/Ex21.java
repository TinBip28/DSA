package week3.ex5;

import java.util.Scanner;

public class Ex21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
       SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        for (int i = 0; i < n; i++) {
            list.addBot(input.nextInt());
        }
        list.print();
    }
}
