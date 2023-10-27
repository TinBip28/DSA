package week5.ex1;

import javax.lang.model.element.UnknownElementException;

public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<T> {
    protected static class Node<E> {
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
        return p.left != null ? p.left : new Node<E>(element, p, null, null);
    }

    public Node<E> addRight(Node p, E element) {
        if (p == null) {
            throw new IndexOutOfBoundsException("Can not define p");
        }
        return p.right != null ? p.right : new Node<E>(element, p, null, null);
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
}
