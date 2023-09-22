package week1.hw1_ex4;

public class Main {
    public static void main(String[] args) {
        Sphere sphere1 = new Sphere();
        Sphere sphere2 = new Sphere(1,2,0,0);

        System.out.println(sphere1);
        System.out.println(sphere2);

        System.out.print("Thể tích hình cầu: ");
        System.out.println(sphere1.volume());

        System.out.print("Diện tích hình cầu: ");
        System.out.println(sphere1.surroundingArea());

        sphere1.contact(sphere2);
    }
}
