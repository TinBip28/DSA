package week2.card_game;

import java.util.Arrays;

public class Deck {
    public static void main(String[] args) {
        Card[] deck = new Card[20];
        for (int i = 0; i < 20; i++) {
            deck[i] = new Card();
        }
        System.out.println(Arrays.toString(deck));
        Arrays.sort(deck);
        System.out.println(Arrays.toString(deck));
    }
}
