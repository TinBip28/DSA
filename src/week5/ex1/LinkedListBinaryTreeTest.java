package week5.ex1;

import java.io.FileWriter;
import java.io.IOException;

public class LinkedListBinaryTreeTest {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> tree = new LinkedBinaryTree<>();
        tree.addRoot(1);
        LinkedBinaryTree.Node<Integer> nodeLeft = tree.addLeft(tree.root(), 2);
        LinkedBinaryTree.Node<Integer> nodeRight = tree.addRight(tree.root(), 3);
        LinkedBinaryTree.Node<Integer> leaf1 = tree.addLeft(nodeLeft, 4);
        LinkedBinaryTree.Node<Integer> leaf2 = tree.addRight(nodeLeft, 6);
        LinkedBinaryTree.Node<Integer> leaf3 = tree.addLeft(nodeRight, 5);
        LinkedBinaryTree.Node<Integer> leaf4 = tree.addRight(nodeRight, 7);
        tree.printTree(tree.root(), 0);
        System.out.println("\n");
        try {
            FileWriter fileWriter = new FileWriter("D:\\Intellij\\DSA\\src\\week5\\ex1\\outputLinked.txt");
            fileWriter.write("Linked Binary Tree\n");
            tree.writeTree(tree.root(),0,fileWriter);
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
