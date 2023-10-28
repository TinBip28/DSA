package week5.ex1;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
    private E[] array;
    private int n = 0;
    private int defaultSize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultSize];
    }

    public void setRoot(E element) {
//      Đặt giá trị cho root tại cây rỗng
        array[1] = element;
    }

    public void setLeft(int p, E element) {
        int childLeft = (p * 2) + 1;

        if (array[p] == null) {
            System.out.printf("No parent found for child at %d\n", childLeft);
        } else {
            array[childLeft] = element;
        }
    }

    public void setRight(int p, E element) {
        int childRight = (p * 2) + 2;

        if (array[p] == null) {
            System.out.printf("No parent found for child at %d\n", childRight);
        } else {
            array[childRight] = element;
        }
    }

    @Override
    public T root() {
        return (T) array[1];
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
    public int numChildren(T p) {
        int count = 0;
        if (left(p) != null) count++;
        if (right(p) != null) count++;
        return count;
    }

    @Override
    public T parent(T p) {
        if ((int) p > size()) throw new IndexOutOfBoundsException();
        return (T) array[(int) p / 2];
    }

    @Override
    public T left(T p) {
        if ((int) p * 2 + 1 > size()) throw new IndexOutOfBoundsException();
        return (T) array[(int) p * 2 + 1];
    }

    @Override
    public T right(T p) {
        if ((int) p * 2 + 2 > size()) throw new IndexOutOfBoundsException();
        return (T) array[(int) p * 2 + 2];
    }

    @Override
    public T sibling(T p) {
        if ((int) p + 1 > size()) throw new IndexOutOfBoundsException();
        return (T) array[(int) p + 1];
    }

    public void printTreeArray() {
        for (int i = 1; i <= n; i++) {
            System.out.print("[" + array[i] + "]");
        }
    }
}

