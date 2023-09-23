package week2.card_game;

import java.util.Arrays;

public class Deck {
    private Card[] cardDeck;

    public static void main(String[] args) {
        Card[] deck = new Card[20];
        for (int i = 0; i < 20; i++) {
            deck[i] = new Card();
        }
        System.out.println(Arrays.toString(deck));
        Arrays.sort(deck);
        System.out.println(Arrays.toString(deck));
    }

    public Card[] createData(int length) {
        return new Card[2];
    }

    public boolean cardCheck(Card o) {
        if (o == null) {
            return false;
        }
        for (int i = 0; i < cardDeck.length; i++) {
            if (cardDeck[i].getClass() == o.getClass()) {
                return false;
            }
        }
        return true;
    }
}
