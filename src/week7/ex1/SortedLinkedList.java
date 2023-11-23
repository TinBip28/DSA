package week7.ex1;

public class SortedLinkedList<T> implements ListInterface<T> {

    protected class Node<T> {
        Node<T> next;
        T element;

        public Node(T element) {
            this.element = element;
        }
    }

    Node<T> head;
    private int n;

    @Override
    public void add(T data) {
        Node<T> node = new Node(data);
        if (isEmpty()) {
            head = node;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        n++;
    }

    @Override
    public void isContain(T data) {
        int l = 0;
        int r = n - 1;
        Node<T> node = head;
        while (l <= r) {
            int mid = (l + r) / 2;
            for (int i = 0; i < mid; i++) {
                node = node.next;
            }
            if (node.element == data) {
                System.out.println("Contain");
                break;
            } else if (((Comparable<T>) data).compareTo(node.element) < 0) {
                l = mid - 1;
            } else {
                r = mid + 1;
            }
            node = head;
        }
    }

    public void swap(Node<T> ptr1, Node<T> ptr2) {
        T tmp = ptr2.element;
        ptr2.element = ptr1.element;
        ptr1.element = tmp;
    }

    // Function to sort the list
    void bubbleSort(Node<T> head) {
        boolean swapped;
        Node current;

        if (head == null)
            return;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                if ((Integer) current.element > (Integer) current.next.element) {
                    swap(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
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
    public String toString() {
        StringBuilder string = new StringBuilder();
        Node<T> node = head;
        while (node != null) {
            string.append(node.element).append(" ");
            node = node.next;
        }
        return string.toString();
    }
}
