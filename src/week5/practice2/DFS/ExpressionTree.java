package week5.practice2.DFS;

import java.util.LinkedList;
import java.util.Stack;

public class ExpressionTree<E> extends LinkedBinaryTree {
    LinkedList<String> list = new LinkedList<>();

    public void preorderPrint(Node<E> p) {
        if (p == null)
            return;

        // First print data of node
        System.out.print(p.element + " ");

        // Then recur on left subtree
        preorderPrint(p.left);

        // Now recur on right subtree
        preorderPrint(p.right);
    }

    public void postorderPrint(Node<E> p) {
        if (p == null) return;

        // First recur on left subtree
        postorderPrint(p.left);

        // Then recur on right subtree
        postorderPrint(p.right);

        list.add((String) p.element);
        // Now deal with the node
        System.out.print(p.element + " ");

    }

    public void inorderPrint(Node<E> p) {
        if (p == null)
            return;

        // First recur on left child
        inorderPrint(p.left);

        // Then print the data of node
        System.out.print(p.element + " ");

        // Now recur on right child
        inorderPrint(p.right);
    }
}
