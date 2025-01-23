package week8.ex2;

import java.util.Arrays;

public class TestDirectedGraph {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(4);
        graph.insertEdge(0,1,2);
        graph.insertEdge(1,3,5);
        graph.insertEdge(2,1,7);
        System.out.println(graph);
        int[] edge = graph.getEdge(0,1);
        System.out.println("getEdge(): " + Arrays.toString(edge));

        int[] endVertices = graph.endVertices(7);
        System.out.println("endVertices(): " + Arrays.toString(endVertices));

    }
}
