package week5.lt1;

import week5.ex1.LinkedBinaryTree;

public class HeightAndDepthOfBinaryTree {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> tree = new LinkedBinaryTree<>();
        tree.addRoot(1);
        LinkedBinaryTree.Node<Integer> nodeLeft = tree.addLeft(tree.root(), 2);
        LinkedBinaryTree.Node<Integer> nodeRight = tree.addRight(tree.root(), 3);
        LinkedBinaryTree.Node<Integer> leaf1 = tree.addLeft(nodeLeft, 4);
        LinkedBinaryTree.Node<Integer> leaf2 = tree.addRight(nodeLeft, 6);
        LinkedBinaryTree.Node<Integer> leaf3 = tree.addLeft(nodeRight, 5);
        LinkedBinaryTree.Node<Integer> leaf4 = tree.addRight(nodeRight, 7);
        int depth = tree.findDepth(tree.root(),5);
        System.out.println(depth);
        int height = tree.findHeight(tree.root(),1);
        System.out.println(height);
    }
}
