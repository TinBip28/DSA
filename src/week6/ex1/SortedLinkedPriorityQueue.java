package week6.ex1;

public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
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
    public void insert(Entry<K, E> entry) {
        NodeEntry<K, E> start = head;
        NodeEntry<K, E> tmp = (NodeEntry<K, E>) entry;
        if (start == null) {
            head = (NodeEntry<K, E>) entry;
            tail = head;
        } else {
            while (start.next != null && start.next.key.compareTo(entry.getKey()) < 0) {
                start = start.next;
            }
            tmp.next = start.next;
            start.next = tmp;
        }
    }

    @Override
    public void insert(K k, E e) {
        insert(new NodeEntry<>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        return null;
    }

    @Override
    public Entry<K, E> min() {
        return head;
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
