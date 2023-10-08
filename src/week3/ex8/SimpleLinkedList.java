package week3.ex8;

public class SimpleLinkedList<T> {
    class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
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

    private Node getNodeByIndex(int index) {
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

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(getNodeByIndex(i).data + " ");
        }
        System.out.println();
    }

    public int getNthFromLast(int n)
    {
        // Your code here
        if (top == null){
            return -1;
        }
        Node current1 = top;
        Node current2 = top;
        while (n-- != 0){
            current2 = current2.next;
            if (current2 == null && n >0){
                return -1;
            }
        }
        while (current2 != null){
            current2 = current2.next;
            current1 = current1.next;
        }
        return current1.data;
    }
}
