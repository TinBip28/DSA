package week2.card_game;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Deck deck = new Deck();

        System.out.println(Arrays.toString(deck.getDeck()));
        deck.shuffleCard();
        System.out.println(Arrays.toString(deck.getDeck()));


        System.out.println();
        Deck deck1 = new Deck(10, 12);
        System.out.println(Arrays.toString(deck1.getDeck()));
        ISort quick = new QuickSort();
        quick.sort(deck1.getDeck());
        System.out.println(Arrays.toString(deck1.getDeck()));
    }
}
