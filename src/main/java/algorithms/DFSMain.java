package algorithms;

import java.util.Map;

public class DFSMain {
    public static <T> void dfs(Graph<T> graph, T start, Map<T, Boolean> visited) {
        if (!visited.get(start)) {
            visited.put(start, true);
            System.out.println(start);
            for (T node : graph.neighbors(start)) {
                dfs(graph, node, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph<Integer> graph = GraphTestUtil.getSamples();
        Integer start = 1;
        Map<Integer, Boolean> visited = GraphTestUtil.initializeVisited();

        dfs(graph, start, visited);
    }
}
