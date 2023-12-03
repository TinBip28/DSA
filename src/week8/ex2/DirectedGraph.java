package week8.ex2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DirectedGraph {
    private int vertices;
    private int edges;
    private int[][] graph;

    public DirectedGraph(int vertices) {
        this.vertices = vertices;
        this.graph = new int[vertices][vertices];
    }

    public void insertEdge(int start, int end, int weight) {
        checkOutOfBoundIndex(start, end);
        graph[start][end] = weight;
        edges++;
    }

    public void insertVertex() {
        vertices++;
        int i;
        for (i = 0; i < vertices; ++i) {
            graph[i][vertices - 1] = 0;
            graph[vertices - 1][i] = 0;
        }
    }

    public void removeVertex(int vertex) {
        checkOutOfBound(vertex);
        int i;
        while (vertex < vertices) {
            for (i = 0; i < vertices; ++i) graph[i][vertex] = graph[i][vertex + 1];
            for (i = 0; i < vertices; ++i) graph[vertex][i] = graph[vertex + 1][i];
            vertex++;
        }
        // decreasing the number of vertices
        vertices--;
    }

    public int numVertices() {
        return vertices;
    }

    public int numEdges() {
        return edges;
    }

    public Map<Integer, Integer> incomingEdges(int vertex) {
        Map<Integer, Integer> imcoimg = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            if (graph[i][vertex] != 0) {
                imcoimg.put(i, vertex);
            }
        }
        return imcoimg;
    }

    public Map<Integer, Integer> outcomingEdges(int vertex) {
        Map<Integer, Integer> outcoming = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            if (graph[vertex][i] != 0) outcoming.put(vertex, i);
        }
        return outcoming;
    }

    public int opposite(int vertex) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[vertex][i] != 0 || graph[i][vertex] != 0) {
                return i;
            }
        }
        return -1;
    }

    public int[] getEdge(int u, int v) {
        checkOutOfBoundIndex(u, v);
        if (graph[u][v] != 0) {
            try {
                return new int[]{u, v};
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public int[] endVertices(int weight) {
        int[] vertices = new int[2];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == weight) {
                    vertices[0] = i;
                    vertices[1] = j;
                }
                if (graph[j][i] == weight) {
                    vertices[0] = j;
                    vertices[1] = i;
                }
            }
        }
        return vertices;
    }

    public Set<Integer> vertices() {
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] != 0) list.add(i);
            }
        }
        return list;
    }

    public void checkOutOfBoundIndex(int i, int j) {
        if (i < 0 || i > graph.length || j < 0 || j > graph.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void checkOutOfBound(int i) {
        if (i < 0 || i > vertices) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        for (int i = 0; i < vertices; i++) {
            sb.append(i + 1).append("\t");
        }
        sb.append("\n");
        for (int i = 0; i < vertices; i++) {
            sb.append(i + 1).append("\t");
            for (int j = 0; j < vertices; j++) {
                sb.append(graph[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
