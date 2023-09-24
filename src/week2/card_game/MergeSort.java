package week2.card_game;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<Card extends Comparable<Card>> implements ISort<Card> {

    @Override
    public void sort(Card[] arr) {

        sort(arr, 0, arr.length - 1);

    }

    public void sort(Card[] data, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(data, l, m);
            sort(data, m + 1, r);
            merge(data, l, m, r);
        }
    }

    public void merge(Card[] data, int low, int mid, int high) {
        int n = high - low + 1;
        List<Card> b = new ArrayList<>(n);
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (data[left].compareTo(data[right]) <= 0)
                b.add(data[left++]);
            else b.add(data[right++]);
        }
        while (left <= mid) b.add(data[left++]);
        while (right <= high) b.add(data[right++]);
        for (int k = 0; k < n; k++) {
            data[low + k] = b.get(k);
        }
    }
}
