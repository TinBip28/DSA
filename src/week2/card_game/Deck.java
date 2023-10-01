package week2.card_game;

import java.util.*;

public class Deck {
    private Card[] cards;

    //tạo ra bộ bài hoàn chỉnh chưa sắp xếp;
    public Deck() {
        List<Card> list = new ArrayList<>();
        int[] suits = new int[]{1, 2, 3, 4};
        int[] ranks = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        for (int suit : suits) {
            for (int rank : ranks) {
                list.add(new Card(suit, rank));
            }
        }
        cards = new Card[52];
        for (int i = 0; i < list.size(); i++) {
            cards[i] = list.get(i);
        }
    }

    public Deck(int N, int M) throws Exception {
        if (N > M) {
            throw new Exception();
        }
        cards = new Card[N];
        for (int i = 0; i < cards.length; i++) {
            do {
                cards[i] = new Card();
            } while (cards[i].getRank() <= M && checkCards(cards, cards[i]));
        }
    }

    private boolean checkCards(Card[] cards, Card o) {
        for (Card card : cards) {
            if (card.compareTo(o) == 0) {
                return false;
            }
        }
        return true;
    }

    public Card[] getDeck() {
        return cards;
    }

    public void shuffleCard() {
        List<Card> list = new ArrayList<>(Arrays.stream(cards).toList());
        Collections.shuffle(list);
        cards = new Card[52];
        for (int i = 0; i < list.size(); i++) {
            cards[i] = list.get(i);
        }
    }
}
