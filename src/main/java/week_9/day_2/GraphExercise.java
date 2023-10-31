package week_9.day_2;

import java.util.*;

public class GraphExercise {
    public static void main(String[] args) {

    }
}

class Graph {
    private Map<Vertex, List<Vertex>> adjVertices;

    public Graph(Map<Vertex, List<Vertex>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public Map<Vertex, List<Vertex>> getAdjVertices() {
        return adjVertices;
    }

    public void setAdjVertices(Map<Vertex, List<Vertex>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    void addVertex(int v) {
        adjVertices.putIfAbsent(new Vertex(v), new ArrayList<>());
    }

    void addEdge(int v1, int v2) {
        Vertex vertex1 = new Vertex(v1);
        Vertex vertex2 = new Vertex(v2);
        adjVertices.get(vertex1).add(vertex2);
        adjVertices.get(vertex2).add(vertex1);
    }

    public List<Vertex> getNeighbors(int v) {
        Vertex vertex = new Vertex(v);
        return adjVertices.getOrDefault(vertex, new LinkedList<>());
    }

    // Depth-First Search
    public static void dfs(Graph graph, int v, Set<Vertex> visited) {
        Vertex vertex = new Vertex(v);
        visited.add(vertex);
        System.out.println("Visited vertex: " + v);

        List<Vertex> neighbors = graph.getNeighbors(v);
        for (Vertex neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor.getV(), visited);
            }
        }
    }

    // Breath-First Search
    public static void bfs(Graph graph, Vertex start) {
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            System.out.println("Visited vertex: " + vertex);

            List<Vertex> neighbors = graph.getNeighbors(vertex.getV());
            for (Vertex neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}

class Vertex {
    int v;

    Vertex(int v) {
        this.v = v;
    }

    public int getV() {
        return v;
    }
}