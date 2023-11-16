package week6.ex2;

import week6.ex1.Entry;
import week6.ex1.SortedArrayPriorityQueue;
import week6.ex1.UnsortedArrayPriorityQueue;

import java.util.Arrays;

public class MinHeapPriorityQueue<K extends Comparable, E> extends UnsortedArrayPriorityQueue<K, E> {
    ArrEntry<K, E> heapPQ[];

    public MinHeapPriorityQueue() {
        this.heapPQ = array;
    }

    public void upHeap() {
        int current = size() - 1;
        while (current > 0) {
            int parent = current / 2;
            if (heapPQ[current].getKey().compareTo(heapPQ[parent].getKey()) >= 0) break;
            swap(current, parent);
            current = parent;
        }
    }

    public void downHeap(int j) {
        while ((2 * j + 1) < size()) { // continue to bottom (or break statement)
            int leftIndex = j * 2 + 1;
            int smallChildIndex = leftIndex; // although right may be smaller
            if ((2 * j + 2) < size()) {
                int rightIndex = j * 2 + 2;
                if (heapPQ[leftIndex].getKey().compareTo(heapPQ[rightIndex].getKey()) > 0)
                    smallChildIndex = rightIndex; // right child is smaller
            }
            if (heapPQ[smallChildIndex].getKey().compareTo(heapPQ[j].getKey()) >= 0)
                break; // heap property has been restored
            swap(j, smallChildIndex);
            j = smallChildIndex; // continue at position of the child
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
