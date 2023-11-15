package week6.ex2;

import week6.ex1.Entry;
import week6.ex1.SortedArrayPriorityQueue;

import java.util.Arrays;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue<K, E> {
    ArrEntry<K, E> heapPQ[];

    public MinHeapPriorityQueue() {
        this.heapPQ = array;
    }

    public void upHeap() {
        int current = size() - 1;
        int parent = (current) / 2;
        while (heapPQ[parent].getKey().compareTo(heapPQ[current].getKey()) > 0 && current != 0) {
            swap(parent, current);
            current = parent;
            parent = (current) / 2;
        }
    }

    public void downHeap() {
        int current = 0;
        while (2 * current < size()) {
            int leftChild = 2 * current + 1;
            int rightChild = leftChild + 1;
            int minIdx = current;

            if (leftChild < size() && heapPQ[leftChild].getKey().compareTo(heapPQ[minIdx].getKey()) < 0) {
                minIdx = leftChild;
            }

            if (rightChild < size() && heapPQ[rightChild].getKey().compareTo(heapPQ[minIdx].getKey()) < 0) {
                minIdx = rightChild;
            }

            if (minIdx != current) {
                swap(current, minIdx);
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        ArrEntry<K, E> tmp = heapPQ[i];
        heapPQ[i] = heapPQ[j];
        heapPQ[j] = tmp;
    }

    public void print() {
        for (int i = 0; i < size(); i++) {
            System.out.print(heapPQ[i] + " ");
        }
    }

}
