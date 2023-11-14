package week6.ex1;

public class ArrayQueue {
    public static void main(String[] args) {
        UnsortedArrayPriorityQueue<Integer, Character> queue = new UnsortedArrayPriorityQueue<>();
        insertData(queue);
        System.out.println("\n");
        SortedArrayPriorityQueue<Integer, Character> queue1 = new SortedArrayPriorityQueue<>();
        insertData(queue1);
    }

    public static void insertData (UnsortedArrayPriorityQueue<Integer, Character> queue){
        queue.insert(1,'A');
        queue.insert(4,'C');
        queue.insert(2,'E');
        queue.insert(3,'F');
        queue.insert(5,'D');
        System.out.println(queue);
        System.out.println(queue.min());
        System.out.println(queue.removeMin());
        System.out.println(queue);
    }

    public static void insertData(SortedArrayPriorityQueue<Integer, Character> queue){
        queue.insert(5,'C');
        queue.insert(2,'A');
        queue.insert(3,'B');
        queue.insert(1,'E');
        queue.insert(4,'F');
        System.out.println(queue);
        System.out.println(queue.min());
    }
}
