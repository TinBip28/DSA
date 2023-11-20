package week7.ex2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class TestMain {
    static Random random = new Random();

    public static void main(String[] args) {
        LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> tree = new LinkedBinaryTree<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        try {
            FileWriter fileWriter = new FileWriter("D:\\Intellij\\DSA\\src\\week7\\ex2\\Output.txt");
            fileWriter.write("Linked Binary Tree\n");
            createData1E6(tree, list1);
            fileWriter.write(Objects.requireNonNull(getTime(tree, list1)));
            fileWriter.write("\n");
            createData1E7(tree, list1);
            fileWriter.write(Objects.requireNonNull(getTime(tree, list1)));
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createData1E6(LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> tree, LinkedList<Integer> list) {
        LinkedBinaryTree.Node<Integer> root = tree.addRoot(random.nextInt());
        for (int i = 1; i < 1E6; i++) {
            int val = random.nextInt();
            tree.insert(val, root);
            list.add(val);
        }
    }

    public static void createData1E7(LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> tree, LinkedList<Integer> list) {
        LinkedBinaryTree.Node<Integer> root = tree.addRoot(random.nextInt());
        for (int i = 1; i < 1E7; i++) {
            int val = random.nextInt();
            tree.insert(val, root);
            list.add(val);
        }
    }

    public static void createData1E8(LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> tree, LinkedList<Integer> list) {
        LinkedBinaryTree.Node<Integer> root = tree.addRoot(random.nextInt());
        for (int i = 1; i < 1E8; i++) {
            int val = random.nextInt();
            tree.insert(val, root);
            list.add(val);
        }
    }

    public static String getTime(LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> tree, LinkedList<Integer> linkedList) {
        LinkedBinaryTree.Node<Integer> root = tree.root();
        LinkedList<Integer>.Node head = linkedList.getNodeByIndex(0);
        ArrayList<Integer> list = new ArrayList<>();
        tree.inorder(root, list);

        StringBuilder builder = new StringBuilder();

        int findValue = random.nextInt(0, list.size());

        long start = System.nanoTime();
        tree.search(findValue, root);
        long end = System.nanoTime();
        builder.append("Binary tree seaching: ").append(end - start).append("\n");

        start = System.nanoTime();
        linkedList.binarySearch(head, findValue);
        end = System.nanoTime();
        builder.append("Binary searching: ").append(end - start).append("\n");

        start = System.nanoTime();
        linkedList.search(head, findValue);
        end = System.nanoTime();
        builder.append("Searching normal: ").append(end - start).append("\n");
        return builder.toString();
    }
}
