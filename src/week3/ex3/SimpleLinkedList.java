package week3.ex3;

public class SimpleLinkedList<T> {
    class Node {
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

    private void add(T data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
            bot = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        n++;
    }

    private void addBot(T data) {
        Node newNode = new Node(data);
        if (bot == null) {
            top = newNode;
            bot = newNode;
        } else {
            newNode.next = bot;
            bot = newNode;
        }
        n++;
    }

    public T get(int i) {
        checkBoundaries(i, size());
        Node current = top;
        for (int index = 0; index < i; i++) {
            current = current.next;
        }
        return (T) current;
    }

    protected void checkBoundaries(int index, int limit) {
        if (index < 0 || index >= limit) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void set(int i, T data) {
        checkBoundaries(i, n - 1);
        Node current = (Node) get(i);
        current.setData(data);
    }

    public boolean isContain(T data) {
        for (int i = 0; i < size(); i++) {
            Node current = (Node) get(i);
            if (current == data) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public T removeTop() {
        if (top == null)
            return null;
        top = top.next;
        n--;
        return (T) top;
    }

    public T removeBot() {
        bot = (Node) get(size() - 2);
        bot.next = null;
        n--;
        return (T) bot;
    }

    public void remove(T data) {
        if (top == data) {
            n--;
        }
        while (top.next == data) {
            top.next = null;
            n--;
        }
    }
}
