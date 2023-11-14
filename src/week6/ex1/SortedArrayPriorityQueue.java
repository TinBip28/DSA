package week6.ex1;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultSize = 1000;

    public SortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }

    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            this.key = k;
            this.element = e;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }

        @Override
        public String toString() {
            return "{" + key + "," + element + '}';
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
    public void insert(K k, E e) {
        insert(new ArrEntry<>(k, e));
    }

    @Override
    public void insert(Entry<K, E> entry) {
        checkIndex();
        if (isEmpty()) {
            array[0] = (ArrEntry<K, E>) entry;
        } else {
            int i = n - 1;
            while (i >= 0 && array[i].key.compareTo(entry.getKey()) <= 0) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = (ArrEntry<K, E>) entry;
        }
        n++;
    }


    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        Entry<K, E> min = array[n - 1];
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        return array[size() - 1];
    }

    private void checkIndex() {
        if (size() >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size() - 1; i++) {
            result.append(array[i] + " ");
        }
        result.append(array[size() - 1]);
        result.append("]");
        return result.toString();
    }
}
