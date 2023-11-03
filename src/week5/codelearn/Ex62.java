package week5.codelearn;

import java.util.Scanner;

public class Ex62 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        BinaryTree bt = new BinaryTree();
        for (int i = 0; i < n; i++) {
            bt.addNode(arr[i]);
        }
        bt.traverseInOrder(bt.root);
    }
}

