package week7.ex1;

public class UnSortedLinkedList<T> implements ListInterface<T> {

    protected class Node<T> {
        Node<T> next;
        T element;

        public Node(T element) {
            this.element = element;
        }
    }

    private Node<T> head;
    private int n;

    @Override
    public void add(T data) {
        Node<T> node = new Node(data);
        if(isEmpty()){
            head = node;
        } else {
            Node<T> current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = node;
        }
        n++;
    }

    @Override
    public void isContain(T data) {
        Node<T> current = head;
        while (current != null){
            if(current.element == data){
                System.out.println("contain");
            }
            current = current.next;
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Node<T> node = head;
        while (node != null){
            string.append(node.element).append(" ");
            node = node.next;
        }
        return string.toString();
    }
}
