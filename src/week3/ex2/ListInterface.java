package week3.ex2;

public interface ListInterface<T> extends Iterable<T> {
    public void add(T data);

    public Object get(int i);

    public void set(int i, T data);

    public void remove(T data);

    public void isContain(T data);

    public int size();

    public boolean isEmpty();


}
