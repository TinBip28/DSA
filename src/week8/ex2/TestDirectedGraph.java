package week8.ex2;

public class TestDirectedGraph {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(4);
        graph.insertEdge(0,1,2);
        System.out.println(graph);

    }
}
