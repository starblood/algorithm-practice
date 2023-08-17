package practice;

import algorithms.Graph;
import algorithms.GraphTestUtil;

import java.util.Map;

public class DFSTest {
    public static void dfs(Graph<Integer> graph, int start, Map<Integer, Boolean> visited) {
        if (!visited.get(start)) {
            visited.put(start, true);
            System.out.println(start);
            for (int i : graph.neighbors(start)) {
                dfs(graph, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph<Integer> samples = GraphTestUtil.getSamples();
        Map<Integer, Boolean> visited = GraphTestUtil.initializeVisited();

        dfs(samples, 1, visited);
    }
}
