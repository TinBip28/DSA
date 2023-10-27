package week4.ex4;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue);
    }
}
