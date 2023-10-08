package week3.ex5;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData(){
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node node) {
            this.next = node;
        }
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        Node current = new Node(data);
        current.next = top;
        top = current;
        if (isEmpty()) {
            bot = top;
        }
        n++;
    }

    public void addBot(T data) {
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

    public void insert(T data, int index) {
        checkBoundaries(index, n);
        if (index == 0) {
            top = new Node(data, top);
        } else {
            Node nodeByIndex = getNodeByIndex(index - 1);
            nodeByIndex.setNext(new Node(data, nodeByIndex.getNext()));
        }
        n++;
    }

    public T get(int i) {
        return getNodeByIndex(i).getData();
    }

    protected void checkBoundaries(int index, int limit) {
        if (index < 0 || index >= limit) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void set(int i, T data) {
        checkBoundaries(i, n - 1);
        Node current = getNodeByIndex(i);
        current.setData(data);
    }

    public boolean isContain(T data) {
        for (int i = 0; i < size(); i++) {
            Node current = getNodeByIndex(i);
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
        T current = top.data;
        top = top.next;
        n--;
        return current;
    }

    public T removeBot() {
        T data = bot.data;
        bot = getNodeByIndex(n - 2);
        bot.next = null;
        n--;
        return data;
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

    public void removeByIndex(int index) {
        checkBoundaries(index, n - 1);
        if (index == 0) {
            top = top.getNext();
        } else {
            Node current = getNodeByIndex(index - 1);
            current.setNext(current.getNext().getNext());
        }
        n--;
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
}
