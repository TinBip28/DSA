package week2.card_game;

import java.util.*;

public class Deck {
    public static void main(String[] args) {
        Card[] cards = new Card[20];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Card();
        }
        System.out.println(Arrays.toString(cards));
        CardComparison cardComparison = new CardComparison();
        Arrays.sort(cards, cardComparison);
        System.out.println(Arrays.toString(cards));

        Card[] cards1 = new Card[25];
        for (int i = 0; i < cards1.length; i++) {
            cards1[i] = new Card();
        }
        ISort quick = new QuickSort();
        quick.sort(cards1);
        System.out.println(Arrays.toString(cards1));
    }

}
