package week5.ex3;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class Ex3 {
    public static int Priority(String operator) { // độ ưu tiên
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> -1;
        };
    }

    public static String[] infixToPostfix(String[] tokens) {
        Stack<String> stack = new Stack<>();
        String[] res = new String[tokens.length];
        int run = 0;
        char sign = '+';

        for (int i = 0; i < tokens.length; i++) {
            if (Character.isDigit(Integer.parseInt(tokens[i]))) {
                StringBuilder tmp = new StringBuilder();
                int countDot = 0;
                while (i < tokens.length && (Character.isDigit(Integer.parseInt(tokens[i])) || Objects.equals(tokens[i], "."))) {
                    if (Objects.equals(tokens[i], ".")) {
                        countDot++;
                    }
                    tmp.append(tokens[i++]);
                }
                if (countDot > 1) {
                    System.exit(0);
                }
                i--;
                if (sign == '-') {
                    tmp.insert(0, sign);
                    sign = '+';
                }
                res[run++] = tmp.toString();
            } else if (Objects.equals(tokens[i], "(")) {
                stack.push(tokens[i]);
            } else if (Objects.equals(tokens[i], ")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    res[run++] = stack.pop();
                }
                stack.pop();
            } else {
                if ((i == 0 || Objects.equals(tokens[i - 1], "(")) && Objects.equals(tokens[i], "-")) {
                    sign = '-';
                } else {
                    while (!stack.isEmpty() && Priority(tokens[i]) <= Priority(String.valueOf(stack.peek().charAt(0)))) {
                        res[run++] = stack.pop();
                    }
                    stack.push(tokens[i]);
                }
            }
        }
        while (!stack.isEmpty()) {
            res[run++] = stack.pop();
        }
        return Arrays.copyOf(res, run);
    }

    public static String[] infixToPostfix(char[] infix1) {
        String infix = '(' + String.valueOf(infix1) + ')';
        int l = infix.length();
        Stack<Character> stack = new Stack<>();
        String[] output = new String[infix.length()];
        for (int i = 0; i < l; i++) {

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isDigit(infix.charAt(i)))
                output[i] = output[i] + infix.charAt(i);
                // If the scanned character is an
                // ‘(‘, push it to the stack.
            else if (infix.charAt(i) == '(')
                stack.add('(');
                // If the scanned character is an
                // ‘)’, pop and output from the stack
                // until an ‘(‘ is encountered.
            else if (infix.charAt(i) == ')') {
                while (stack.peek() != '(') {
                    output[i] += stack.peek();
                    stack.pop();
                }

                // Remove '(' from the stack
                stack.pop();
            }
        }
        return output;
    }
}
