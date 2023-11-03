package week5.codelearn;

import java.util.Scanner;

public class Ex63 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < n; i++)
            tree.addNode(sc.nextInt());

        System.out.print(tree.countLeaf(tree.root));
    }
}
