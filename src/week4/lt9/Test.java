package week4.lt9;

public class Test {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(5);
            circularQueue.enQueue(1);
            circularQueue.enQueue(2);
            circularQueue.enQueue(3);
            circularQueue.enQueue(4);
            circularQueue.enQueue(5);
        System.out.println(circularQueue.front);
        System.out.println(circularQueue.rear);
    }
}
