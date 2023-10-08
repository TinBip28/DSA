package week3.ex6;

public class LinkedListDesign {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    static class MyLinkedList {
        Node head = null;
        int size = 0;

        public MyLinkedList() {
            head = null;
        }

        public int get(int index) {
            checkBoundaries(index, size);
            Node temp = head;
            for (int i = 0; i < index; i++)
                temp = temp.next;
            return temp != null ? temp.data : 0;
        }

        protected void checkBoundaries(int index, int limit) {
            if (index < 0 || index >= limit) {
                throw new IndexOutOfBoundsException();
            }
        }

        public void addAtHead(int val) {
            Node newHead = new Node(val);
            newHead.next = head;
            head = newHead;
            size++;
        }

        public void addAtTail(int val) {
            if (head == null) {
                head = new Node(val);
            } else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = new Node(val);
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index == size) {
                addAtTail(val);
            } else if (index > size) {
                return;
            } else {
                Node newNode = new Node(val);
                if (head == null) {
                    head = newNode;
                } else if (index == 0) {
                    newNode.next = head;
                    head = newNode;
                } else {
                    Node current = head;
                    Node previous = null;
                    for (int i = 0; i < index; i++) {
                        previous = current;
                        current = current.next;
                    }
                    newNode.next = current;
                    previous.next = newNode;
                }
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) return;
            Node current = head;
            Node previous = null;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }
            if (previous == null) {
                head = head.next;
            } else {
                previous.next = current.next;
            }
            size--;
        }

        public void printList() {
            Node current = head;
            while (current.next != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(2);
        list.addAtIndex(0, 10);
        list.printList();
    }

}
