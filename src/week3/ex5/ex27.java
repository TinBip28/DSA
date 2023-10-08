package week3.ex5;

import java.util.LinkedList;
import java.util.Scanner;

public class ex27 {
    class Node {
        int data;
        Node pre;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = n; i >= 1; i--) {
            list.add(i);
        }
        for (int j = 2; j <= n; j++) {
            list.add(j);
        }
        for (Integer a : list) {
            System.out.print(a + " ");
        }
    }
}
