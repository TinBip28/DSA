package week3.ex11;

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

    public boolean isPalindrome() {
        Node slow = top, fast = top, prev, temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = top;
        slow = prev;
        while (slow != null) {
            if (fast.data != slow.data) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
