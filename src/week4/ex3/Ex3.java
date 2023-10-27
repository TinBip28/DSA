package week4.ex3;

import java.util.*;

public class Ex3 {

    public static void main(String[] args) {
        System.out.println(drive("1+2*3+10"));
    }

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

    static int Prec(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }


    public static String[] infixToPostfix(String s) {
        Stack<String> stack = new Stack<>();
        s = s.replaceAll(" ", "");
        String[] res = new String[s.length()];
        int run = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder tmp = new StringBuilder();
                int countDot = 0;
                while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
                    if (s.charAt(i) == '.') {
                        countDot++;
                    }
                    tmp.append(s.charAt(i++));
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
            } else if (s.charAt(i) == '(') {
                stack.push(Character.toString(s.charAt(i)));
            } else if (s.charAt(i) == ')') {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    res[run++] = stack.pop();
                }
                stack.pop();
            } else {
                if ((i == 0 || s.charAt(i - 1) == '(') && s.charAt(i) == '-') {
                    sign = '-';
                } else {
                    while (!stack.isEmpty() && Prec(s.charAt(i)) <= Prec(stack.peek().charAt(0))) {
                        res[run++] = stack.pop();
                    }
                    stack.push(Character.toString(s.charAt(i)));
                }
            }
        }
        while (!stack.isEmpty()) {
            res[run++] = stack.pop();
        }
        return Arrays.copyOf(res, run);
    }

    public static double evaluatePostfix(String[] expr) {
        Stack<Double> values = new Stack<>();
        int i = 0;
        while (i < expr.length) {
            if (isNumber(expr[i])) {
                values.push(Double.parseDouble(expr[i]));
            } else {
                double a = values.pop();
                double b = values.pop();
                switch (expr[i]) {
                    case "+" -> values.push(a + b);
                    case "-" -> values.push(a - b);
                    case "*" -> values.push(a * b);
                    case "/" -> {
                        if (a == 0) throw new ArithmeticException("error: denominator's value is 0.");
                        values.push((b / a));
                    }
                }
            }
            i++;
        }
        return Math.round(values.pop() * 100) / 100.0;
    }

    public static boolean isNumber(String s) {
        return Character.isDigit(s.charAt(s.length() - 1));
    }

    public static double drive(String poly){
        if (bracketsBalanced(poly)){
            return evaluatePostfix(infixToPostfix(poly));
        }
        return 0;
    }
}

