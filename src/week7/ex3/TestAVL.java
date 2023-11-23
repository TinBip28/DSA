package week7.ex3;

public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer, AVLTree.Node<Integer>> tree = new AVLTree<>();
        tree.root = tree.insertToAVL(tree.root, 10);
        tree.root = tree.insertToAVL(tree.root, 20);
        tree.root = tree.insertToAVL(tree.root, 40);
        tree.root = tree.insertToAVL(tree.root, 50);
        tree.root = tree.insertToAVL(tree.root, 25);
        tree.root = tree.insertToAVL(tree.root, 75);
        tree.root = tree.insertToAVL(tree.root, 15);
        tree.printTree(tree.root,0);
    }
}
