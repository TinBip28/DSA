package week2.card_game;

public class QuickSort<Card extends Comparable<Card>> implements ISort<Card> {

    public void quickSort(Card[] data, int l, int r) {
        Card m = data[(l + r) / 2];
        int i = l, j = r;
        while (i < j) {
            while (data[i].compareTo(m) < 0) {
                i++;
            }
            while (data[j].compareTo(m) > 0) {
                j--;

            }
            if (i <= j) {
                Card temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
            }
        }
        if (i < r) {
            quickSort(data, i, r);
        }
        if (l < j) {
            quickSort(data, l, j);
        }
    }

    @Override
    public void sort(Card[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
}
