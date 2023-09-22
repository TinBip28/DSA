package week1.p1_28;

import java.util.Random;

public class SmallPunish {
    private final Random rd = new Random();
    private String sentence = "I will never spam my friends again.";
    private int repeats = 100;

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public void setRepeats(int repeats) {
        this.repeats = repeats;
    }

    public SmallPunish() {
    }

    public void printSentence() {
        int n = rd.nextInt(1, 8);
        for (int i = 0; i <= repeats; i++) {
            StringBuilder write = new StringBuilder(sentence);
            for (int j = 0; j < n; j++) {
                int type = rd.nextInt(sentence.length());
                write.setCharAt(type, (char) (rd.nextInt(26) + 'a'));
            }
            System.out.println(i + " " + write);
        }
    }
}
