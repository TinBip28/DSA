package week3.ex5;

import java.util.Scanner;

public class Ex24 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            list.addBot(input.nextInt());
        }
        int k = input.nextInt();
        while (k < 0 || k > n){
            k = input.nextInt();
        }
        System.out.println(list.get(k));
    }
}
