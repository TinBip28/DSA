package week4.lt1;

import  week4.ex2.ArrayStack;
public class ReverseString_Ex13 {
    public static void main(String[] args) {
        String string = "codelearn";
        StringBuilder res = new StringBuilder();
        ArrayStack<Object> stack = new ArrayStack<>(string.length());
        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }
        for (int i = 0; i < string.length(); i++) {
            res.append(stack.pop());
        }
        System.out.println(res);
    }
}
