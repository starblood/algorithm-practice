package algorithms;

import java.util.*;

public class Graph<T> {
    private Map<T, List<T>> adjList;
    public Graph() {
        adjList = new HashMap<>();
    }

    public List<T> nodes() {
        return adjList.keySet().stream().toList();
    }

    public List<T> neighbors(T node) {
        if (adjList.containsKey(node)) {
            return adjList.get(node);
        } else {
            return new ArrayList<>();
        }
    }

    public Graph<T> addEdge(T from, T to) {
        if (adjList.containsKey(from)) {
            adjList.get(from).add(to);
        } else {
            adjList.put(from, new ArrayList<>(Arrays.asList(to)));
        }
        return this;
    }
}
