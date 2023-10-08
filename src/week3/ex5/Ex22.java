package week3.ex5;

import java.util.Scanner;

public class Ex22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        for (int i = 0; i < n; i++) {
            list.addBot(input.nextInt());
        }
        System.out.print("Nhap vi tri muon chen phan tu ");
        int k = input.nextInt();
        System.out.print("Nhap gia tri phan tu ");
        int x = input.nextInt();
        while (k < 0 || k > n) {
            k = input.nextInt();
        }
        list.insert(x, k);
        list.print();
    }
}
