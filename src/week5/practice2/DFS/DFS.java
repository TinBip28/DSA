package week5.practice2.DFS;

public class DFS {
    public static void main(String[] args) {
        LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> tree = new LinkedBinaryTree<>();
        expression(tree);
        ExpressionTree<String> expressionTree = new ExpressionTree<>();
        arithmeticExpressionPresent(expressionTree, tree);
    }

    public static void expression(LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> tree) {
        LinkedBinaryTree.Node<String> root = tree.addRoot("1");
        LinkedBinaryTree.Node<String> left = tree.addLeft(root, "4");
        LinkedBinaryTree.Node<String> right = tree.addRight(root, "3");
        LinkedBinaryTree.Node<String> leftOne = tree.addLeft(left, "7");
        LinkedBinaryTree.Node<String> rightOne = tree.addRight(left, "2");
        LinkedBinaryTree.Node<String> leftLeftOne = tree.addLeft(leftOne, "5");
        LinkedBinaryTree.Node<String> rightLeftOne = tree.addRight(leftOne, "8");
        LinkedBinaryTree.Node<String> leftTwo = tree.addLeft(right, "9");
        LinkedBinaryTree.Node<String> rightTwo = tree.addRight(right, "6");
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
