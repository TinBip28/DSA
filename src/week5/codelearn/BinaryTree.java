package week5.codelearn;

public class BinaryTree {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public void addNode(int data) {
        root = addNodeRecursive(root, data);
    }

    private Node addNodeRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        if (data <= current.data) {
            current.left = addNodeRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addNodeRecursive(current.right, data);
        } else {
            return current;
        }

        return current;
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    public int countLeaf(Node current) {
        int count = 0;
        if (current != null) {
            if (current.left == null && current.right == null)
                count++;
            else {
                count += countLeaf(current.left);
                count += countLeaf(current.right);
            }
        }
        return count;
    }
}

