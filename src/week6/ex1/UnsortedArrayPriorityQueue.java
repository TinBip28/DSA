package week6.ex1;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        checkIndex();
        array[n] = (ArrEntry<K, E>) entry;
        n++;
    }

    @Override
    public void insert(K k, E e) {
        insert(new ArrEntry<>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        int minIndex = getIndex(min().getKey());
        for (int i = minIndex; i < size(); i++) {
            array[i] = array[i + 1];
        }
        n--;
        System.out.print("New min ");
        return min();
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        int minIndex = 0;
        for (int i = 0; i < size(); i++) {
            if (array[minIndex].key.compareTo(array[i].key) > 0) {
                minIndex = i;
            }
        }
        return array[minIndex];
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

    private int getIndex(K key) {
        int index = 0;
        for (int i = 0; i < size(); i++) {
            if (key.compareTo(array[i].key) == 0) {
                index = i;
            }
        }
        return index;
    }

    private void checkIndex() {
        if (size() >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultsize = 1000;

    public UnsortedArrayPriorityQueue() {
        this.array = new ArrEntry[defaultsize];
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
