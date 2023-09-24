package week2.card_game;

public class InsertionSort<Card extends Comparable<Card>> implements ISort<Card> {
    @Override
    public void sort(Card[] data) {
        for (int i = 1; i < data.length; ++i) {
            Card key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j].compareTo(key) > 0) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
    }
}
