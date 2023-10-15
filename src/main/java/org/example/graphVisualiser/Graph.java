package org.example.graphVisualiser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    Map<Main.Animal, Set<Main.Animal>> adjacencyList = new HashMap<>();

    public void addVertex(Main.Animal vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<Main.Animal>());
    }

    public void addEdge(Main.Animal vertex1, Main.Animal vertex2) {
        addVertex(vertex1);
        addVertex(vertex2);
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    public boolean isInGraph(Main.Animal vertex1) {
        return adjacencyList.containsKey(vertex1);
    }
    public boolean isConnected(Main.Animal vertex1, Main.Animal vertex2) {
        if (isInGraph(vertex1) && isInGraph(vertex2)) {
            return adjacencyList.get(vertex1).contains(vertex2);
        }
        return false;
    }

    public Set<Main.Animal> getVertices() {
        return adjacencyList.keySet();
    }

    public Set<Main.Animal> getAdjacentVertices(Main.Animal vertex) {
        return adjacencyList.get(vertex);
    }

}
