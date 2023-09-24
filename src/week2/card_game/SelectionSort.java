package week2.card_game;

public class SelectionSort<Card extends Comparable<Card>> implements ISort<Card> {

    @Override
    public void sort(Card[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < data.length; j++) {

                if (data[j].compareTo(data[minIdx]) < 0) {
                    minIdx = j;
                }
                Card temp = data[minIdx];
                data[minIdx] = data[i];
                data[i] = temp;

            }
        }
    }


}
