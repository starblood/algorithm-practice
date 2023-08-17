package practice;

import algorithms.Graph;
import algorithms.GraphTestUtil;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFSTest {
    public static void bfs(Graph<Integer> graph, int start, Map<Integer, Boolean> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited.put(start, true);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node);
            for (int n : graph.neighbors(node)) {
                if (!visited.get(n)) {
                    queue.offer(n);
                    visited.put(n, true);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph<Integer> graph = GraphTestUtil.getSamples();
        Map<Integer, Boolean> visited = GraphTestUtil.initializeVisited();

        bfs(graph, 1, visited);
    }
}
