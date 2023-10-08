package week3.ex5;

import java.util.Scanner;

public class Ex28 {

    static class DouList {
        Node head;
        Node tail;

        public void printList() {
            Node temp = this.head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

        DouList() {

        }

        DouList(int x) {
            this.head = new Node(null, x, null);
            this.tail = this.head;
        }

        public void addHead(int x) {
            Node temp = new Node(null, x, head);
            head.prev = temp;
            head = temp;
        }

        public void addTail(int x) {
            Node temp = new Node(tail, x, null);
            tail.next = temp;
            tail = temp;
        }

        public void addAt(int k, int x) {
            Node p = head;
            for (int i = 0; i < k - 1; i++) {
                p = p.next;
            }
            Node temp = new Node(p, x, p.next);
            p.next.prev = temp;
            p.next = temp;
        }

        public void deleteAt(int index) {
            Node temp = head;
            Node ptr = temp.next;
            if (index == 0) {
                head = null;
            }
            if (index == 1) {
                temp.next.prev = null;
                head = head.next;
            }
            for (int i = 1; i < (index - 1); i++) {
                temp = ptr;
                ptr = ptr.next;
            }
            temp.next = ptr.next;
        }

        public void sortedInsert(int x) {
            Node temp = new Node(null, x, null);
            if (head == null) {
                head = temp;
                tail = temp;
            }
            if (x < head.data) {
                temp.next = head;
                head.prev = temp;
                head = temp;
            }
            Node curr = head;
            while (curr.next != null && x > curr.next.data) {
                curr = curr.next;
            }
            if (curr.next == null) {
                temp.prev = curr;
                curr.next = temp;
                tail = temp;
            } else {
                temp.next = curr.next;
                temp.prev = curr;
                curr.next.prev = temp;
                curr.next = temp;
            }
        }
    }

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(Node prev, int data, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        DouList list = new DouList(x);
        for (int i = 1; i < n; i++) {
            x = input.nextInt();
            list.addTail(x);
        }
        list.printList();
        int k = input.nextInt();
        x = input.nextInt();
        if (k == 0) list.addHead(x);
        else if (k == n) list.addTail(x);
        else list.addAt(k, x);
        list.printList();
        list.deleteAt(2);
        System.out.println();
        list.printList();
        System.out.println();
        list.sortedInsert(8);
        list.printList();
    }
}
