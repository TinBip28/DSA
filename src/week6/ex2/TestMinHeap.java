package week6.ex2;

public class TestMinHeap {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, Character> minHeapPriorityQueue = new MinHeapPriorityQueue<>();
        minHeapPriorityQueue.insert(2, 'B');
        minHeapPriorityQueue.insert(3, 'A');
        minHeapPriorityQueue.insert(1, 'C');
        minHeapPriorityQueue.insert(4, 'D');


        minHeapPriorityQueue.print();
        System.out.println();

        minHeapPriorityQueue.downHeap();
        minHeapPriorityQueue.print();
        System.out.println();

//        minHeapPriorityQueue.upHeap();
//        minHeapPriorityQueue.print();

    }
}
