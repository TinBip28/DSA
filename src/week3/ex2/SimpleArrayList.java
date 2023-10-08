package week3.ex2;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n;
    private final int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T data) {
        if (array.length == size()) {
            enlarge();
        }
        array[n++] = data;
    }

    @Override
    public Object get(int i) {
        checkBoundaries(i, size());
        return array[i];
    }

    @Override
    public void set(int i, T data) {
        checkBoundaries(i, size());
        if (size() == array.length) {
            enlarge();
        }
        array[i] = data;
    }

    @Override
    public void remove(Object data) {
        int index = 0;
        for (int i = 0; i < size(); i++) {
            if (data.equals(array[i])) {
                index = i;
            }
        }

        for (int i = index; i < size() - 1; i++) {
            array[index] = array[index + 1];
        }
    }

    @Override
    public void isContain(Object data) {
        for (T ele : array) {
            if (data.equals(ele)){
                System.out.println("Is contain");
                break;
            }
        }
        System.out.println("Is not contain");
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator(array);
    }

    public boolean hasNext() {
        /* TODO */
        return n < array.length && array[n] != null;
    }

    public void enlarge() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    protected void checkBoundaries(int index, int limit) {
        if (index < 0 || index >= limit) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
