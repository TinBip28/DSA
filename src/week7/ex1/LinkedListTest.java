package week7.ex1;

import java.util.Random;

public class LinkedListTest {
    public static void main(String[] args) {
        Random random = new Random();
        UnSortedArrayList<Integer> list = new UnSortedArrayList<>();
        for (int i = 0; i < 40; i++) {
            list.add(random.nextInt(3, 999));
        }
        list.add(50);
        list.isContain(50);

        SortedLinkedList<Integer> linkedList = new SortedLinkedList<>();
        for (int i = 0; i < 40; i++) {
            linkedList.add(50);
        }
        linkedList.bubbleSort(linkedList.head);
        linkedList.add(50);
        linkedList.isContain(50);
    }
}
