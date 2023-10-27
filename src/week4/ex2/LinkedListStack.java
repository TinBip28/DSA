package week4.ex2;

import org.jfree.util.StackableException;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    private class Node {
        E element;
        Node next;
    }


    private Node stack = null;

    @Override
    public void push(E element) {
        Node temp = new Node();
        if (temp == null) {
            System.out.print("\nHeap Overflow");
            return;
        }

        temp.element = element;
        temp.next = stack;
        stack = temp;
    }

    @Override
    public E pop() {
        if (stack == null) {
            System.out.println("Heap Underflow");
        }
        return stack.element;
    }

    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public E top() {
        if (stack != null) {
            return stack.element;
        } else {
            System.out.println("Stack Underflow");
        }
        return null;
    }

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "stack=" + stack +
                '}';
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }

}
