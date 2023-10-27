package week4.ex5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome(String string){
        String split = string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        int i = 0;
        while (i < string.length()){
            stack.push(split.charAt(i));
            queue.add(split.charAt(i));
            i++;
        }
        for (int j = 0; i < stack.size(); j++) {
            if (stack.pop() != queue.poll()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String string = "abccba";
        System.out.println("Palindrome: " + isPalindrome(string));
    }
}
