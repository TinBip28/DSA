package week2.card_game;

import java.util.Random;

public class Card implements Comparable<Card> {
    private int suit; // Rô Cơ Bích Tép
    private int rank; // [1,...,13]
    private final Random random = new Random();

    public Card() {
        this.suit = random.nextInt(1, 5);
        this.rank = random.nextInt(1, 14);
    }

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }


    public int getSuit() {
        return suit;
    }


    public int getRank() {
        return rank;
    }

    public Card getCard() {
        return new Card(this.suit, this.rank);
    }

    @Override
    public String toString() {
        String nameVal = "";
        if (rank == 11) {
            nameVal += "J";
        } else if (rank == 12) {
            nameVal += "Q";
        } else if (rank == 13) {
            nameVal += "K";
        } else {
            nameVal = Integer.toString(rank);
        }
        String nameSuit = "";
        if (suit == 1) {
            nameSuit += "Bich";
        } else if (suit == 2) {
            nameSuit += "Tep";
        } else if (suit == 3) {
            nameSuit += "Ro";
        } else {
            nameSuit += "Co";
        }
        return nameVal + " " + nameSuit;
    }


    @Override
    public int compareTo(Card a) {
        int dex = Integer.compare(this.suit, a.suit);
        if (dex < 0) {
            return -1;
        } else if (dex == 0) {
            return Integer.compare(this.rank, a.rank);
        } else {
            return 1;
        }
    }
}
