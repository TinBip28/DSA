package week1.p1_28;

public class Main {
    public static void main(String[] args) {
        SmallPunish smallPunish = new SmallPunish();
        smallPunish.printSentence();
        System.out.println();
        SmallPunish smallPunish1 = new SmallPunish();
        smallPunish1.setRepeats(150);
        smallPunish1.setSentence("Dai hoc Khoa hoc Tu nhien");
        smallPunish1.printSentence();
    }
}
