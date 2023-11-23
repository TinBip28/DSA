package week7.ex2;

import week5.ex1.BinaryTreeInterface;
import week5.ex1.LinkedBinaryTree;

public class LinkedBinarySearchTree<E, T> implements BinaryTreeInterface<T> {
    public static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            this.element = e;
            this.parent = above;
            this.left = leftChild;
            this.right = rightChild;
        }

        public Node(E e) {
            this.element = e;
        }

        @Override
        public String toString() {
            return "Node[" +
                    "element=" + element +
                    ']';
        }
    }

    @Override
    public T root() {
        return (T) root;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(T p) {
        return 0;
    }

    @Override
    public T parent(T p) {
        Node<E> current = (Node<E>) p;
        return (T) current.parent;
    }

    @Override
    public T left(T p) {
        Node<E> current = (Node<E>) p;
        return (T) current.left;
    }

    @Override
    public T right(T p) {
        Node<E> current = (Node<E>) p;
        return (T) current.right;
    }

    @Override
    public T sibling(T p) {
        Node<E> current = (Node<E>) p;
        Node<E> parrent = current.parent;
        if (p == parrent.right) {
            return (T) parrent.left;
        } else {
            return (T) parrent.right;
        }
    }

    private int n = 0;
    Node<E> root;

    public Node<E> addRoot(E element) {
        if (isEmpty()) {
            root = new Node<>(element);
        }
        n++;
        return root;
    }

    public void insert(E element) {
        root = insertRec(root, element);
    }

    private Node<E> insertRec(Node<E> root, E key) {
        // If the tree is empty,
        // return a new node
        if (root == null) {
            root = new Node<E>(key);
            return root;
        }

        // Otherwise, recur down the tree
        else if ((int) key < (int) root.element)
            root.left = insertRec(root.left, key);
        else if ((int) key > (int) root.element)
            root.right = insertRec(root.right, key);

        // Return the (unchanged) node pointer
        return root;
    }

    public Node<E> search(E key, Node<E> node) {
        if (node == null || (int) node.element == (int) key)
            return node;

        // Key is greater than root's key
        if ((int) node.element < (int) key)
            return search(key, node.right);

        // Key is smaller than root's key
        return search(key, node.left);
    }

    public int findMin() {
        Node<E> current = root;
        while (current.left != null) {
            current = current.left;
        }
        return (int) current.element;
    }

    public Node<E> deleteNode(Node<E> root, E element) {
        // Base case
        if (root == null)
            throw new IllegalStateException("Root null");

        // Recursive calls for ancestors of
        // node to be deleted
        if ((int) root.element > (int) element) {
            root.left = deleteNode(root.left, element);
            return root;
        } else if ((int) root.element < (int) element) {
            root.right = deleteNode(root.right, element);
            return root;
        }

        // We reach here when root is the node
        // to be deleted.

        // If one of the children is empty
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        // If both children exist
        else {

            Node<E> succParent = root;

            // Find successor
            Node<E> succ = root.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            if (succParent != root)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;

            // Copy Successor Data to root
            root.element = succ.element;

            // Delete Successor and return root
            return root;
        }
    }

    void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node<E> root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.element + " ");
            inorderRec(root.right);
        }
    }

    public void printTree(Node<E> node, int level) {
        if (node != null) {
            printTree(node.right, level + 1);
            if (level != 0) {
                for (int i = 0; i < level - 1; i++) {
                    System.out.print("\t\t");
                }
                System.out.print("\t\t" + node.element + "\n");
            } else {
                System.out.print((Integer) node.element + "\n");
            }
            printTree(node.left, level + 1);
        }
    }
}
