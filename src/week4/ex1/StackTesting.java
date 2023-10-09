package week4.ex1;

import java.util.Stack;

public class StackTesting {
    public static void main(String[] args) {
        Stack<Character> names = new Stack<>();
        String name = "lequangtin";
        for (int i = 0; i < name.length(); i++) {
            if (i % 2 == 0) {
                names.push(name.charAt(i));
            }
            if (i % 3 == 0) {
                names.pop();
            }
        }
        System.out.println(names);
    }
    //Lưu vào stack những kí tự ở vị trí chia hết cho 2 và xuất ra những kí tự ở vị trí chia hết cho 6
}
