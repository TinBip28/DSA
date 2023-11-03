package week5.codelearn;

import java.util.Scanner;

public class Ex62 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        BinaryTree bt = new BinaryTree();
        for (int i = 0; i < n; i++) {
            bt.addNode(array[i]);
        }
        bt.traverseInOrder(bt.root);
    }
}

