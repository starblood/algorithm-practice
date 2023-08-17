package algorithms;

import java.util.HashMap;
import java.util.Map;

public class GraphTestUtil {
    public static Map<Integer, Boolean> initializeVisited() {
        Map<Integer, Boolean> visited = new HashMap<>();
        visited.put(1, false); visited.put(2, false);
        visited.put(3, false); visited.put(4, false);
        visited.put(5, false); visited.put(6, false);
        visited.put(7, false); visited.put(8, false);

        return visited;
    }

    public static Graph<Integer> getSamples() {
        return new Graph<Integer>()
                .addEdge(1, 2).addEdge(1, 3).addEdge(1, 8)
                .addEdge(2, 1).addEdge(2, 7)
                .addEdge(3, 1).addEdge(3, 4).addEdge(3, 5)
                .addEdge(4, 3).addEdge(4, 5)
                .addEdge(5, 3).addEdge(5, 4)
                .addEdge(6, 7)
                .addEdge(7, 2).addEdge(7, 6).addEdge(7, 8)
                .addEdge(8, 1).addEdge(8, 7);
    }
}
