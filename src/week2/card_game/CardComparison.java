package week2.card_game;

import java.util.Comparator;

public class CardComparison implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        int suitDiff = o1.getSuit() - o2.getSuit();
        if (suitDiff < 0) {
            return -1;
        } else if (suitDiff == 0) {
            return Integer.compare(o1.getRank(), o2.getRank());
        } else {
            return 1;
        }
    }
}
