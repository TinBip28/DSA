package week7.ex2;

import week3.ex3.SimpleLinkedList;


public class LinkedList<T> {
    public class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void add(T data) {
        Node current = new Node(data);
        current.next = top;
        top = current;
        if (isEmpty()) {
            bot = top;
        }
        n++;
    }

    public T get(int i) {
        return getNodeByIndex(i).data;
    }

    public T search(Node head, T data) {
        Node current = head;
        while (current != null){
            if (current.data == data){
                return current.data;
            }
            current = current.next;
        }
        return null;
    }


    public Node middleNode(Node head, Node tail) {
        if (head == null)
            return null;

        Node slow = head;
        Node fast = head.next;

        while (fast != tail) {
            fast = fast.next;
            if (fast != tail) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    public Node binarySearch(Node head, T value) {
        Node start = head;
        Node last = null;

        do {
            // Find Middle
            Node mid = middleNode(start, last);

            // If middle is empty
            if (mid == null)
                return null;

            // If value is present at middle
            if (mid.data == value)
                return mid;

                // If value is less than mid
            else if ((int) mid.data > (int) value) {
                last = mid;
            }

            // If the value is more than mid.
            else
                start = mid.next;
        } while (last == null || last != start);

        // value not present
        return null;
    }


    public Node getNodeByIndex(int index) {
        Node current;
        if (index < 0 || index > n) {
            throw new ArrayIndexOutOfBoundsException();
        }
        current = top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


}
