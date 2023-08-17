package algorithms;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFSMain {

    public static <T> void bfs(Graph<T> graph, T start, Map<T, Boolean> visited) {
        Queue<T> queue = new LinkedList<>();
        queue.offer(start);
        visited.put(start, true);
        while (!queue.isEmpty()) {
            T node = queue.poll();
            System.out.println(node); // process node
            for (T n : graph.neighbors(node)) {
                if (!visited.get(n)) {
                    queue.offer(n);
                    visited.put(n, true);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph<Integer> graph = GraphTestUtil.getSamples();
        Integer start = 1;
        // initialize 1 to 8 node visit to be false
        Map<Integer, Boolean> visited = GraphTestUtil.initializeVisited();

        bfs(graph, start, visited);
    }
}
