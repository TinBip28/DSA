package week4.ex2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class ArrayStack<E> implements StackInterface<E> {
    public static final int CAPACITY = 1000;

    private Random random = new Random();
    private final E[] data;
    private int t = -1;

    public ArrayStack() {
        data = (E[]) new Object[CAPACITY];
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return t + 1;
    }

    @Override
    public void push(E element) throws IllegalAccessError {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    @Override
    public Iterator<E> iterator() {
        return new StackEnum();
    }
    @Override
    public String toString() {
        return "ArrayStack{" +
                "data=" + Arrays.toString(data) +
                ", t=" + t +
                '}';
    }

    class StackEnum implements Iterator<E> {
        int pos = data.length;

        @Override
        public boolean hasNext() {
            return pos != 0;
        }

        @Override
        public E next() {
            E ele;
            if (pos != 0) {
                ele = data[pos];
                pos--;
            } else {
                throw new NoSuchElementException();
            }
            return ele;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}