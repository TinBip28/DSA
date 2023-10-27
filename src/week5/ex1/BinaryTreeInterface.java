package week5.ex1;

public interface BinaryTreeInterface<T> {
    T root();
    int size();
    boolean Empty();
    int numChildren(T p);
    T parent(T p);
    T left(T p);
    T right(T p);
    T sibling(T p);
}
