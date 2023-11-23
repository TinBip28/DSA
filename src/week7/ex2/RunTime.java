package week7.ex2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RunTime {
    static Random random = new Random();

    public static void main(String[] args) {
        LinkedBinarySearchTree<Integer, LinkedBinarySearchTree.Node<Integer>> tree = new LinkedBinarySearchTree<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        try {
            FileWriter fileWriter = new FileWriter("D:\\Intellij\\DSA\\src\\week7\\ex2\\Output.txt");
            fileWriter.write("Để đến 1E5 chạy cho nhanh nha thầy :)) em lưu sẵn bên file.txt rồi thầy\n");
            fileWriter.write(getTime(tree, list1));
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getTime(LinkedBinarySearchTree<Integer, LinkedBinarySearchTree.Node<Integer>> tree, LinkedList<Integer> linkedList) {
        for (int i = 0; i < 1E5; i++) {
            int val = random.nextInt(100000);
            linkedList.add(val);
        }
        linkedList.sortList();
        LinkedBinarySearchTree.Node<Integer> root = tree.root();
        LinkedList<Integer>.Node head = linkedList.getNodeByIndex(0);

        StringBuilder builder = new StringBuilder();

        int findValue = linkedList.get(random.nextInt(500, 2000));

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
        builder.append("Lineear searching: ").append(end - start).append("\n");
        return builder.toString();
    }
}
