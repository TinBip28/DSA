package week8.ex1;

public interface GraphInterface<V, E> {
    int numVertices();

    int numEdges();

    Iterable<Vertex<V>> vertices();

    Iterable<Edge<E, V>> edges();

    Iterable<Edge<E, V>> incomingEdges(Vertex<V> v);

    Iterable<Edge<E, V>> outgoingEdges(Vertex<V> v);

    Vertex<V> opposite(Vertex<V> v, Vertex<V> e);

    Vertex<V> insertVertex(V element);

    Edge<E, V> getEdge(Vertex<V> u, Vertex<V> v);

    Edge<E, V> insertEdge(Vertex<V> u, Vertex<V> v, E element);

    Edge<E, V> insertEdge(V uElement, V vElement, E eElement);

    V removeVertex(Vertex<V> v);

    E removeEdge(Edge<E, V> e);
}
