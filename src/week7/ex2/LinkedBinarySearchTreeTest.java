package week7.ex2;


public class LinkedBinarySearchTreeTest {
    public static void main(String[] args) {
        LinkedBinarySearchTree<Integer, LinkedBinarySearchTree.Node<Integer>> tree = new LinkedBinarySearchTree<>();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.printTree(tree.root(), 0);
        System.out.println();
        System.out.println("findMin: " + tree.findMin());
        System.out.println("search: " + tree.search(20, tree.root));
        System.out.println("delete: " + tree.deleteNode(tree.root, 50));
        System.out.println();
        tree.printTree(tree.root(), 0);
    }
}
