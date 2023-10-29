package week5.ex2;

import java.util.LinkedList;
import java.util.Stack;

public class ExpressionTree<E> extends LinkedBinaryTree {
    LinkedList<String> list = new LinkedList<>();

    public void preorderPrint(Node<E> p) {
        if (p == null)
            return;

        // First print data of node
        System.out.print(p.element + " ");

        // Then recur on left subtree
        preorderPrint(p.left);

        // Now recur on right subtree
        preorderPrint(p.right);
    }

    public void postorderPrint(Node<E> p) {
        if (p == null) return;

        // First recur on left subtree
        postorderPrint(p.left);

        // Then recur on right subtree
        postorderPrint(p.right);

        list.add((String) p.element);
        // Now deal with the node
        System.out.print(p.element + " ");

    }

    public void inorderPrint(Node<E> p) {
        if (p == null)
            return;

        // First recur on left child
        inorderPrint(p.left);

        // Then print the data of node
        System.out.print(p.element + " ");

        // Now recur on right child
        inorderPrint(p.right);
    }

    public double calculate() {
        Stack<Double> values = new Stack<>();
        int i = 0;
        while (i < list.size()) {
            if (isNumber(list.get(i))) {
                values.push(Double.parseDouble(list.get(i)));
            } else {
                double a = values.pop();
                double b = values.pop();
                switch (list.get(i)) {
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
}
