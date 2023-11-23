package week7.ex1;

import java.util.Arrays;

public class SortedArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n;
    private final int defaultSize = 100;

    public SortedArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SortedArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T data) {
        if (isEmpty()) {
            array[0] = data;
        } else {
            int index = n - 1;
            while (index >= 0 && (Integer) data <= (Integer) array[index]) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = data;
        }
        n++;
    }

    @Override
    public void isContain(Object data) {
        for (T ele : array) {
            if (data.equals(ele)) {
                System.out.println("Is contain");
                break;
            }
        }
    }

    public int binarySearch(T data) {
        int l = 0;
        int r = size();
        while (l <= r) {
            int mid = (l + r) / 2;
            if (array[mid].equals(data)) {
                return mid;
            } else if (((Comparable<T>) data).compareTo(array[mid]) < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
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
