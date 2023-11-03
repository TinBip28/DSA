package week5.ex1;

import javax.lang.model.element.UnknownElementException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

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
    }

    private int height = -1;

    private int n;
    private Node<E> root;

    public Node<E> addRoot(E element) {
        if (isEmpty()) {
            root = new Node<E>(element, null, null, null);
        }
        n++;
        return root;
    }

    public Node<E> addLeft(Node p, E element) {
        if (p == null) {
            throw new IndexOutOfBoundsException("Can not define p");
        }
        n++;
        p.left = p.left != null ? p.left : new Node<E>(element, p, null, null);
        return p.left;
    }

    public Node<E> addRight(Node p, E element) {
        if (p == null) {
            throw new IndexOutOfBoundsException("Can not define p");
        }
        n++;
        p.right = p.right != null ? p.right : new Node<E>(element, p, null, null);
        return p.right;
    }

    public void set(Node p, E element) {
        if (p == null) {
            throw new IndexOutOfBoundsException("Can not define p");
        }
        p.element = element;
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

    public void printTree(Node node, int level) {
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

    public void writeTree(Node node, int level, FileWriter fileWriter) throws IOException {
        if (node != null) {
            writeTree(node.right, level + 1, fileWriter);
            if (level != 0) {
                for (int i = 0; i < level - 1; i++) {
                    fileWriter.write("\t\t");
                }
                fileWriter.write("\t\t" + node.element + "\n");
            } else {
                fileWriter.write((Integer) node.element + "\n");
            }
            writeTree(node.left, level + 1, fileWriter);
        }
    }

    public static class SumLeftLeaves {
        public int sumOfLeftLeaves(Node root) {
            return helper(root);
        }

        int helper(Node root) {
            if (root == null) return 0;
            int s = 0;
            if (root.left != null && root.left.left == null && root.left.right == null) {
                s += (int) root.left.element;
            }
            s += helper(root.left);
            s += helper(root.right);
            return s;
        }
    }

    public int findDepth(Node root, int x) {

        // Base case
        if (root == null)
            return -1;

        // Initialize distance as -1
        int dist = -1;

        // Check if x is current node=
        if (((int) root.element == x) ||

                // Otherwise, check if x is
                // present in the left subtree
                (dist = findDepth(root.left, x)) >= 0 ||

                // Otherwise, check if x is
                // present in the right subtree
                (dist = findDepth(root.right, x)) >= 0)

            // Return depth of the node
            return dist + 1;

        return dist;
    }

    public int findHeightUtil(Node root, int x) {

        // Base Case
        if (root == null) {
            return -1;
        }

        // Store the maximum height of
        // the left and right subtree
        int leftHeight = findHeightUtil(root.left, x);

        int rightHeight = findHeightUtil(root.right, x);

        // Update height of the current node
        int ans = Math.max(leftHeight, rightHeight) + 1;

        // If current node is the required node
        if ((int) root.element == x)
            height = ans;

        return ans;
    }

    public int findHeight(Node root, int x) {

        // Stores height of the Tree
        findHeightUtil(root, x);

        // Return the height
        return height;
    }

    public int getLeafCount(Node root){
        // initializing queue for level order traversal
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        // initializing count variable
        int count = 0;
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.left == null && temp.right == null) count++;
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
        }
        return count;
    }
}
