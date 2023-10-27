package week4.ex2;

import java.util.Random;

public class Main {
    public static Random random = new Random();
    public static void main(String[] args) {
        //Tạo Array Stack với capacity mặc định
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        //Thêm phần tử ở trên đầu stack
        arrayStack.push(11);
        arrayStack.push(12);
        System.out.println(arrayStack);

        ArrayStack<Integer> arrayStack1 = new ArrayStack<>(10);
        for (int i = 0; i < 10; i++) {
            arrayStack1.push(random.nextInt(-100, 101));
        }
        //In phần tử ở trên đỉnh stack
        System.out.println(arrayStack1);
        System.out.println("Top of stack: " + arrayStack1.top());


        LinkedListStack<Integer> listStack = new LinkedListStack<>();
        listStack.push(3);
        listStack.push(2);
        System.out.println("Top of stack: " + listStack.pop());
    }
}
