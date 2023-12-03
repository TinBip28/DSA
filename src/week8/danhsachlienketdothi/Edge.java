package week8.danhsachlienketdothi;

public interface Edge<E, V> {
    E element();
    Vertex<V>[] vertices();
}
