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

    public void downHeap() {
        int current = 0;
        while (hasLeftChild(current)){
            int leftChild = leftIndex(current);
            int smallIndex = leftChild;

            if (hasRightChild(current)){
                int rightChild = rightIndex(current);
                if (heapPQ[leftChild].getKey().compareTo(heapPQ[rightChild].getKey()) > 0){
                    smallIndex = rightChild;
                }
            }

            if (heapPQ[smallIndex].getKey().compareTo(heapPQ[current].getKey()) >= 0){
                break;
            }
            swap(current, smallIndex);
            current = smallIndex;
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

    private boolean hasLeftChild(int index) {
        return leftIndex(index) < size();
    }

    private boolean hasRightChild(int index) {
        return rightIndex(index) < size();
    }

    private int leftIndex(int index) {
        return 2 * index + 1;
    }

    private int rightIndex(int index) {
        return 2 * index + 2;
    }

}
