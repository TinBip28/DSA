package week8.ex1;

public interface Edge<E, V> {
    E element();
    Vertex<V>[] vertices();
}
