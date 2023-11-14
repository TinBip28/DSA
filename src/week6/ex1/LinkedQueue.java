package week6.ex1;

public class LinkedQueue {
    public static void main(String[] args) {
        UnsortedLinkedPriorityQueue<Integer, Character> queue = new UnsortedLinkedPriorityQueue<Integer, Character>();
        insertData(queue);

    }

    public static void insertData(UnsortedLinkedPriorityQueue<Integer, Character> queue) {
        queue.insert(1,'A');
        queue.insert(4,'C');
        queue.insert(2,'E');
        queue.insert(3,'F');
        queue.insert(5,'D');
        System.out.println(queue);
    }
}
