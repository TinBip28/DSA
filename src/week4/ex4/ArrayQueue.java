package week4.ex4;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;

    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    public ArrayQueue() {
        queue = (E[]) new Object[default_size];
    }

    @Override
    public void enqueue(E element) throws IllegalStateException {
        if (queue.length == n) throw new IllegalStateException("Queue is full");
        int avail = (top + n) % queue.length;
        queue[avail] = element;
        n++;
    }

    @Override
    public E dequeue() {
       if (isEmpty()) return null;
       E answer = queue[top];
       queue[top] = null;
       top = (top + 1) % queue.length;
       n--;
       return answer;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "queue=" + Arrays.toString(queue) +
                '}';
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;

        @Override
        public boolean hasNext() {
            // TODO Auto - generated method stub
            return num < count;
        }

        @Override
        public E next() {
            // TODO Auto - generated method stub
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }
}
