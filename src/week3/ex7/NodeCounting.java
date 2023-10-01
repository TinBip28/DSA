package week3.ex7;

import java.util.Scanner;

public class NodeCounting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = new Node(sc.nextInt());
        Node tail = head;
        for (int i = 0; i < n - 1; i++) {
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }
        System.out.println(getCount(head));
    }

    public static int getCount(Node head) {
        int count = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }
}