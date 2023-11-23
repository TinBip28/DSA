package week7.ex3;

import week5.ex1.BinaryTreeInterface;


public class AVLTree<E, T> implements BinaryTreeInterface<T> {
    public static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        private int height;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            this.element = e;
            this.parent = above;
            this.left = leftChild;
            this.right = rightChild;
        }

        public Node(E e) {
            this.element = e;
            this.height = 1;
        }

        @Override
        public String toString() {
            return "Node[" + "element=" + element + ']';
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

    public int height(Node<E> node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }

    public Node<E> leftRotate(Node<E> a) {
        Node<E> b = a.right;
        Node<E> t2 = b.left;
        b.left = a;
        a.right = t2;
        a.height = Math.max(height(a.left), height(a.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;
        return b;
    }

    public Node<E> rightRotate(Node<E> a) {
        Node<E> b = a.left;
        Node<E> t2 = b.right;
        b.right = a;
        a.left = t2;
        a.height = Math.max(height(a.left), height(a.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;
        return b;
    }

    int getBalance(Node<E> N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    public Node<E> insertToAVL(Node<E> node, E key) {

        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new Node<E>(key));

        if ((int) key < (int) node.element)
            node.left = insertToAVL(node.left, key);
        else if ((int) key > (int) node.element)
            node.right = insertToAVL(node.right, key);
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + Math.max(height(node.left),
                height(node.right));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && (int) key < (int) node.left.element)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && (int) key > (int) node.right.element)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && (int) key > (int) node.left.element) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && (int) key < (int) node.right.element) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node

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
