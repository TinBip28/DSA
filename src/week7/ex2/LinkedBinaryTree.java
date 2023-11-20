package week7.ex2;

import week5.ex1.BinaryTreeInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<T> {
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

    public Node<E> insert(E element, Node<E> p) {
        if (p == null)
            return new Node<>(element);
        if ((int) element < (int) p.element) {
            p.left = insert(element, p.left);
        } else if ((int) element > (int) p.element) {
            p.right = insert(element, p.right);
        }
        n++;
        return p;
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

    public void inorder(Node<E> node, ArrayList<E> sorted) {
        if (node == null) {
            return;
        }
        inorder(node.left, sorted);

        sorted.add(node.element);

        inorder(node.right, sorted);
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
                System.out.print(node.element + "\n");
            }
            printTree(node.left, level + 1);
        }
    }

    public void writeTree(Node<E> node, int level, FileWriter fileWriter) throws IOException {
        if (node != null) {
            writeTree(node.right, level + 1, fileWriter);
            if (level != 0) {
                for (int i = 0; i < level - 1; i++) {
                    fileWriter.write("\t\t");
                }
                fileWriter.write("\t\t" + node.element + "\n");
            } else {
                fileWriter.write(node.element + "\n");
            }
            writeTree(node.left, level + 1, fileWriter);
        }
    }
}
