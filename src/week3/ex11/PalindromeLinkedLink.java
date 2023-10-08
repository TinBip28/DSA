package week3.ex11;


import java.util.Scanner;

public class PalindromeLinkedLink {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SimpleLinkedList list = new SimpleLinkedList();
        for (int i = 0; i < n; i++) {
            list.addBot(input.nextInt());
        }
        list.print();
        System.out.println(list.isPalindrome());
    }
}
