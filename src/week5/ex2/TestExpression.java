package week5.ex2;

public class TestExpression {
    public static void main(String[] args) {
        LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> tree = new LinkedBinaryTree<>();
        expression(tree);
        ExpressionTree<String> expressionTree = new ExpressionTree<>();
        arithmeticExpressionPresent(expressionTree, tree);

        System.out.println("\nCalculator: " + expressionTree.calculate());
    }

    public static void expression(LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> tree) {
        LinkedBinaryTree.Node<String> root = tree.addRoot("*");
        LinkedBinaryTree.Node<String> left = tree.addLeft(root, "+");
        LinkedBinaryTree.Node<String> right = tree.addRight(root, "-");
        LinkedBinaryTree.Node<String> leftOne = tree.addLeft(left, "/");
        LinkedBinaryTree.Node<String> rightOne = tree.addRight(left, "2");
        LinkedBinaryTree.Node<String> leftLeftOne = tree.addLeft(leftOne, "6");
        LinkedBinaryTree.Node<String> rightLeftOne = tree.addRight(leftOne, "3");
        LinkedBinaryTree.Node<String> leftTwo = tree.addLeft(right, "7");
        LinkedBinaryTree.Node<String> rightTwo = tree.addRight(right, "4");
    }

    public static void arithmeticExpressionPresent(ExpressionTree<String> expression, LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> tree) {
        System.out.println("Inorder expression: ");
        expression.inorderPrint(tree.root());
        System.out.println();
        System.out.println("Preorder expression: ");
        expression.preorderPrint(tree.root());
        System.out.println();
        System.out.println("Postorder expression");
        expression.postorderPrint(tree.root());
        System.out.println();

    }
}
