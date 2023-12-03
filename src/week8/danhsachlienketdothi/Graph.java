package week8.danhsachlienketdothi;

import java.util.*;

public class Graph<V, E> implements GraphInterface<V, E> {
    public class GraphVertex implements Vertex<V> {
        private V vertex;
        private Map<Vertex<V>, Edge<E, V>> outGoingEdges, imComingEdges;

        public GraphVertex(V vertex, Map<Vertex<V>, Edge<E, V>> outGoingEdges, Map<Vertex<V>, Edge<E, V>> imComingEdges) {
            this.vertex = vertex;
            this.outGoingEdges = outGoingEdges;
            this.imComingEdges = imComingEdges;
        }

        public GraphVertex(V element) {
            this.vertex = element;
            this.outGoingEdges = new HashMap<>();
            this.imComingEdges = new HashMap<>();
        }

        @Override
        public V vertex() {
            return vertex;
        }

        public Map<Vertex<V>, Edge<E, V>> getOutgoingEdges() {
            return outGoingEdges;
        }

        public Map<Vertex<V>, Edge<E, V>> getIncomingEdges() {
            return imComingEdges;
        }

        @Override
        public String toString() {
            return vertex + " ";
        }
    }

    public class GraphEdge<E, V> implements Edge<E, V> {
        private E element;
        private Vertex<V>[] endVertices;

        public GraphEdge(Vertex<V> u, Vertex<V> v) {
            this.endVertices = (Vertex<V>[]) new Vertex[]{u, v};
        }

        public GraphEdge(Vertex<V> u, Vertex<V> v, E element) {
            this.element = element;
            this.endVertices = (Vertex<V>[]) new Vertex[]{u, v};
        }

        @Override
        public E element() {
            return element;
        }

        @Override
        public Vertex<V>[] vertices() {
            return endVertices;
        }

        @Override
        public String toString() {
            if (element == null){
                element = (E) "";
            }
            return endVertices[0] + "---------- " + endVertices[1] + " trọng số: " + element;
        }
    }

    private Map<V, Vertex<V>> vertices;
    private Set<Edge<E, V>> edges;

    public Graph() {
        this.vertices = new HashMap<>();
        this.edges = new HashSet<>();
    }

    @Override
    public int numVertices() {
        return vertices.size();
    }

    @Override
    public int numEdges() {
        return edges.size();
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        return vertices.values();
    }

    @Override
    public Iterable<Edge<E, V>> edges() {
        return edges;
    }

    @Override
    public Iterable<Edge<E, V>> incomingEdges(Vertex<V> v) {
        GraphVertex vertex = (GraphVertex) v;
        return vertex.imComingEdges.values();
    }

    @Override
    public Iterable<Edge<E, V>> outgoingEdges(Vertex<V> v) {
        GraphVertex vertex = (GraphVertex) v;
        return vertex.outGoingEdges.values();
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Vertex<V> e) {
        GraphVertex vertex = (GraphVertex) v;
        GraphEdge<E, V> edge = (GraphEdge) e;
        Vertex<V>[] vectices = edge.vertices();
        if (vectices[0].equals(vertex)) {
            return vectices[1];
        } else if (vectices[1].equals(vertex)) {
            return vectices[0];
        } else {
            throw new IllegalStateException("this edge not connect to vertex");
        }
    }

    @Override
    public Vertex<V> insertVertex(V element) {
        GraphVertex vertex = new GraphVertex(element);
        vertices.put(element, vertex);
        return vertex;
    }

    @Override
    public Edge<E, V> getEdge(Vertex<V> u, Vertex<V> v) {
        GraphVertex uEdge = (GraphVertex) u;
        return uEdge.getOutgoingEdges().get(v);
    }

    @Override
    public Edge<E, V> insertEdge(Vertex<V> u, Vertex<V> v, E element) {
        if (getEdge(u, v) == null) {
            GraphVertex startVertex = (GraphVertex) u;
            GraphVertex endVertex = (GraphVertex) v;
            GraphEdge<E, V> edge = new GraphEdge<>(u, v, element);
            edges.add(edge);
            startVertex.outGoingEdges.put(endVertex, edge);
            endVertex.imComingEdges.put(startVertex, edge);
            return edge;
        } else {
            throw new IllegalStateException("Edge already exits");
        }
    }

    @Override
    public Edge<E, V> insertEdge(V uElement, V vElement, E eElement) {
        GraphVertex start = (GraphVertex) vertices.get(uElement);
        GraphVertex end = (GraphVertex) vertices.get(vElement);
        return insertEdge(start, end, eElement);
    }

    public Edge<E, V> insertEdge(V u, V v) {
        GraphVertex start = (GraphVertex) vertices.get(u);
        GraphVertex end = (GraphVertex) vertices.get(v);
        if (getEdge(start, end) == null){
            GraphEdge<E, V> edge = new GraphEdge<>(start, end);
            edges.add(edge);
            start.outGoingEdges.put(end, edge);
            end.imComingEdges.put(start, edge);
            return edge;
        } else {
            throw new IllegalStateException("Edge already exist");
        }
    }

    @Override
    public V removeVertex(Vertex<V> v) {
        GraphVertex vertex = (GraphVertex) v;
        List<Edge<E, V>> removedEdges = new LinkedList<>();

        removedEdges.addAll(vertex.getIncomingEdges().values());
        removedEdges.addAll(vertex.getOutgoingEdges().values());

        for (Edge<E, V> edge : removedEdges) {
            removeEdge(edge);
        }

        V element = v.vertex();
        vertices.remove(v.vertex());
        return element;
    }

    @Override
    public E removeEdge(Edge<E, V> e) {
        GraphEdge<E, V> edge = (GraphEdge<E, V>) e;
        Vertex<V>[] endVertices = edge.vertices();
        GraphVertex start = (GraphVertex) endVertices[0];
        GraphVertex end = (GraphVertex) endVertices[1];
        start.getOutgoingEdges().remove(end);
        end.getIncomingEdges().remove(start);
        edges.remove(edge);
        E element = e.element();
        return element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The graph contain: ").append(numVertices() + " vertices,").append(numEdges() + " edges\n");
        sb.append("Vertices: ");
        for (Vertex<V> vertex : vertices()) {
            sb.append(vertex.toString());
        }
        sb.append("\nEdge: ");
        for (Edge<E, V> edge : edges()) {
            sb.append(edge.toString()).append("\n");
        }
        return sb.toString();
    }
}
