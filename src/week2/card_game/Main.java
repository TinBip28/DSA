package week2.card_game;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Deck deck = new Deck();
        Card[] cards = deck.getDeck();
        System.out.println(Arrays.toString(cards));
        ISort merge = new MergeSort();
        merge.sort(cards);
        System.out.println(Arrays.toString(cards));


        System.out.println();
        Deck deck1 = new Deck(10, 12);
        System.out.println(Arrays.toString(deck1.getDeck()));
        ISort quick = new QuickSort();
        quick.sort(deck1.getDeck());
        System.out.println(Arrays.toString(deck1.getDeck()));
    }
}
