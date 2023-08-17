package baekjoon.datastructure.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q13023 {
    private static boolean found = false;

    private static void initVisited(boolean [] visited) {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] NM = reader.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);

        List<Integer> [] graph = new List[n];
        boolean [] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
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

        for (int i = 0; i < n; i++) {
            if (!found) {
                initVisited(visited);
                dfs(graph, visited, i, 1);
            } else {
                break;
            }
        }
        if (found) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void dfs(List<Integer> [] graph, boolean [] visited, int start, int depth) {
        if (depth == 5) { // A, B, C, D, E => 5명만 만족하면 되므로 5를 사용
            found = true;
            return;
        }
        visited[start] = true;
        for (int i : graph[start]) {
            if (!visited[i]) {
                dfs(graph, visited, i, depth + 1);
            }
        }
        visited[start] = false;
    }
}
