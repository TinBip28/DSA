package week6.ex1;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            this.key = k;
            this.element = e;
        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public E getValue() {
            return null;
        }

        @Override
        public String toString() {
            return "{" + key + "," + element + '}';
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    int n = 0;


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
        NodeEntry<K, E> current = (NodeEntry<K, E>) entry;
        if (isEmpty()) {
            head = current;
            tail = head;
        } else {
            tail.next = current;
            tail = current;
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        insert(new NodeEntry<K, E>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        NodeEntry<K, E> min = (NodeEntry<K, E>) min();
        if (min == head) {
            head = head.next;
            return min;
        }
        NodeEntry<K, E> node = head;
        while (node != null) {
            if (node.next == min) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return min;
    }

    @Override
    public Entry<K, E> min() {
        NodeEntry<K, E> min = head;
        NodeEntry<K, E> node = head;
        while (node != null) {
            if (min.key.compareTo(node.next.getKey()) < 0) {
                min = node;
                node = node.next;
            }
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        NodeEntry<K, E> current = head;
        while (current != null) {
            builder.append(current).append(" ");
            current = current.next;
        }
        builder.replace(builder.length() - 1, builder.length(), "]");
        return builder.toString();
    }
}
