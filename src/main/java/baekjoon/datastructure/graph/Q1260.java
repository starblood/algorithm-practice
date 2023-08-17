package baekjoon.datastructure.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Q1260 {
    public static Queue<Integer> result = new LinkedList<>();

    public static void dfs(List<Integer> [] graph, boolean [] visited, int start) {
        if (!visited[start]) {
            visited[start] = true;
            result.offer(start);
            for (int i : graph[start]) {
                if (!visited[i]) {
                    dfs(graph, visited, i);
                }
            }
        }
    }

    public static void bfs(List<Integer> [] graph, boolean [] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.offer(node);
            for (int i : graph[node]) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);

        List<Integer>[] graph = new List[n + 1];
        boolean [] visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
            visited[i] = false;
        }

        for (int i = 0; i < m; i++) {
            String [] relation = reader.readLine().split(" ");
            int a = Integer.parseInt(relation[0]);
            int b = Integer.parseInt(relation[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(graph[i]);
        }

        dfs(graph, visited, v);
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        for (int i = 1; i < n + 1; i++) {
            visited[i] = false;
        }
        result.clear();

        bfs(graph, visited, v);
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
