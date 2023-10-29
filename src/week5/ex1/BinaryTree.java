package week5.ex1;

import java.io.FileWriter;
import java.io.IOException;

public class BinaryTree {
    public static void main(String[] args) {
        ArrayBinaryTree<Integer, Integer> tree = new ArrayBinaryTree<>();
        createDataForTree(tree);
        int p = 2;
        System.out.println("Parent at position " + p + " is:" + tree.parent(p));
        System.out.println("Left of position " + p + " is:" + tree.left(p));
        System.out.println("The sibling of position " + p + " is:" + tree.left(p));
        System.out.println("Number of childer at positon " + p + " is:" + tree.numChildren(p));
        tree.printTreeArrayFormat();
        tree.printBinaryTree(tree.root(), 0);
        try {
            FileWriter fileWriter = new FileWriter("D:\\Intellij\\DSA\\src\\week5\\ex1\\output.txt");
            fileWriter.write("Array Binary Tree\n");
            tree.toFile(tree.root(),1,fileWriter);
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createDataForTree(ArrayBinaryTree<Integer, Integer> tree) {
        tree.setRoot(1);
        tree.setLeft(1, 2);
        tree.setRight(1, 3);
        tree.setLeft(2, 4);
        tree.setRight(2, 5);
        tree.setLeft(3, 6);
        tree.setRight(3, 7);
    }
}
