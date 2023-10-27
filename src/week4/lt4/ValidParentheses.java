package week4.lt4;

import java.util.Stack;

public class ValidParentheses {
    public static boolean bracketsBalanced(String expr) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
            }
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;
                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;
                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        // Check Empty Stack
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        String string = "{}";
        String string1 = "[)";
        System.out.println(bracketsBalanced(string));
        System.out.println(bracketsBalanced(string1));
    }
}
