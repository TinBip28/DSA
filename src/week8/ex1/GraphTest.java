package week8.ex1;

public class GraphTest {
    public static void main(String[] args) {
        Graph<String, Integer> graph = new Graph<>();
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        graph.insertEdge("A", "B", 1);
        graph.insertEdge("A", "C", 2);
        graph.insertEdge("B", "D", 3);
        graph.insertEdge("E", "F", 4);

        System.out.println(graph);
    }
}
