package hw1_ex1;


import java.util.Scanner;

public class PrimitiveDataTypes {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Boolean: ");
        boolean a = input.nextBoolean();

        System.out.print("Char: ");
        char b = input.next().charAt(0);

        System.out.print("String: ");
        String c = input.next();

        System.out.print("Byte: ");
        byte d = input.nextByte(); // Phạm vi từ -128 đến 127

        System.out.print("Short: ");
        short e = input.nextShort(); // Phạm vi từ -32768 đến 32767

        System.out.print("Integer: ");
        int f = input.nextInt();

        System.out.print("Long: ");
        long g = input.nextLong();

        System.out.print("Float: ");
        float h = input.nextFloat();

        System.out.print("Double: ");
        double i = input.nextDouble();

        System.out.println("boolean " + a);
        System.out.println("char " + b);
        System.out.println("String " + c);
        System.out.println("byte " + d);
        System.out.println("short " + e);
        System.out.println("integer " + f);
        System.out.println("long " + g);
        System.out.println("float " + h);
        System.out.println("double " + i);
    }
}
