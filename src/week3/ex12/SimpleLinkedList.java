package week3.ex12;

public class SimpleLinkedList {
    class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(int data) {
        Node current = new Node(data);
        current.next = top;
        top = current;
        if (isEmpty()) {
            bot = top;
        }
        n++;
    }

    public void addBot(int data) {
        Node node = new Node(data);
        if (isEmpty()) {
            top = node;
            bot = node;
        } else {
            bot.next = node;
            bot = node;
        }
        n++;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int get(int i) {
        return getNodeByIndex(i).data;
    }

    private Node getNodeByIndex(int index) {
        Node current = top;
        if (index < 0 || index > n) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(getNodeByIndex(i).data + " ");
        }
        System.out.println();
    }

    public void deleteDuplicates() {
        Node current = top;
        while (current != null && current.next != null) {
            if (current.getData() == current.next.getData()) {
                current.next = current.next.next;
                n--;
            } else {
                current = current.next;
            }
        }
    }
}
