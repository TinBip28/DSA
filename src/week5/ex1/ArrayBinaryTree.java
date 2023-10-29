package week5.ex1;

import java.io.FileWriter;
import java.io.IOException;

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
        int childLeft = (p * 2);
        n = Math.max(childLeft, n);
        array[childLeft] = element;
    }

    public void setRight(int p, E element) {
        int childRight = (p * 2) + 1;
        n = Math.max(childRight, n);
        array[childRight] = element;
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
        if (p == array[1]){
            return null;
        }
        if ((int) p % 2 == 0){
            return (T) array[(int) p + 1];
        }
        return (T) array[(int) p - 1];
    }

    public void printTreeArrayFormat() {
        for (int i = 1; i <= n; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println("\n");
    }

    public void printBinaryTree(int p, int level) {
        if (p <= n && array[p] != null) {
            printBinaryTree(2 * p, level + 1);
            if (level != 0) {
                for (int i = 0; i < level; i++) {
                    System.out.print("\t\t");
                }
                System.out.println(" " + array[p]);
            } else {
                System.out.print(array[p]);
            }
            printBinaryTree(2 * p + 1, level + 1);
        }
    }

    public void toFile(int p, int level, FileWriter file) throws IOException {
        if (p <= n && array[p] != null) {
            toFile(2 * p , level + 1, file);
            if (level != 0) {
                for (int i = 0; i < level; i++) {
                    file.write("\t\t");
                }
                file.write("\t\t" + array[p] + "\n");
            } else {
                file.write((Integer) array[p]);
            }
            toFile(2 * p + 1, level + 1,file);
        }
    }
}

