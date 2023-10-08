package week3.ex4;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n;
    private final int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    @Override
    public void add(Object data) {
        if (n == size()) {
            enlarge();
        }
        array[n++] = (T) data;
    }

    @Override
    public Object get(int i) {
        try {
            checkBoundaries(i, size());
            return array[i];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Out of index");
        }
        return null;
    }

    @Override
    public void set(int i, Object data) {
        try {
            checkBoundaries(i, size());
            array[i] = (T) data;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Out of index");
        }
    }

    @Override
    public void remove(Object data) {
        int count = 0;
        for (T t : array) {
            if (t == data) {
                count++;
            }
        }
        T[] another = (T[]) new Object[size() - count];
        for (int i = 0, k = 0; i < size(); i++) {
            if (array[i] == data) {
                continue;
            }
            another[k++] = array[i];
        }
        array = Arrays.copyOf(another, another.length);
    }

    @Override
    public void isContain(Object data) {
        int count = 0;
        for (T i : array) {
            if (i == data) {
                count++;
                break;
            }
        }
        if (count == 1) {
            System.out.println("Array contain data");
        } else {
            System.out.println("Array not contain data");
        }
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
    public Iterator<T> iterator() {
        if (hasNext()) {
            return (Iterator<T>) array[n++];
        }
        return null;
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
