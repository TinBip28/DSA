package week2.card_game;

public class BubbleSort<Card extends Comparable<Card>> implements ISort<Card> {
    @Override
    public void sort(Card[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j].compareTo(data[j+1]) > 0) {
                    Card tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }
}