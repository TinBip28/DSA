package week3.ex5;

import java.util.Scanner;

public class Ex23 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            list.addBot(input.nextInt());
        }
        System.out.print("Nhap vi tri muon xoa ");
        int k = input.nextInt();
        while (k < 0 || k >= n) {
            k = input.nextInt();
        }
        list.removeByIndex(k);
        list.print();
    }
}
