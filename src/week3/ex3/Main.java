package week3.ex3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        //Khởi tạo linked list
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        //Thêm phần tử vào linked list
        for (int i = 0; i < 5; i++) {
            list.add(1);
        }
        for (int i = 0; i < 5; i++) {
            list.add(random.nextInt(0,101));
        }

        //In phần tử trong linked list
        list.print();

        //loại bỏ phần tử trong linked list
        list.removeBot();
        list.removeTop();
        list.remove(1);

        list.print();

        //Thay đổi gía trị tại vị trí index
        list.set(1,2023);
        //Kiểm tra xem linkedlist có chứa T data nhập vào không
        System.out.println(list.isContain(2023));
    }
}
