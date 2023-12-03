package week8.ex1;

import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Graph unDirectdGraph = new Graph(4);
        unDirectdGraph.insertEdge(0,1);
        unDirectdGraph.insertEdge(1,3);
        unDirectdGraph.insertEdge(1,2);
        unDirectdGraph.insertEdge(2,3);
        System.out.println(unDirectdGraph);

        Map<Integer, Integer> incoming = unDirectdGraph.incomingEdges(1);
        System.out.print("Incoming edges of vertex 1:" );
        System.out.println(incoming);

        Map<Integer, Integer> outcoming = unDirectdGraph.outcomingEdges(2);
        System.out.print("\nOut coming edges of vertex 2:");
        System.out.println(outcoming);


    }
}
