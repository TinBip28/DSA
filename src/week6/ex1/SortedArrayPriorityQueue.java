package week6.ex1;

public class SortedArrayPriorityQueue <K extends Comparable, E> implements PriorityQueueInterface{
    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry entry) {

    }

    @Override
    public void insert(Object o, Object o2) {

    }

    @Override
    public Entry removeMin() {
        return null;
    }

    @Override
    public Entry min() {
        return null;
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
    }

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultsize = 1000;
}
