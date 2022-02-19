package ru.ifmo.algorithm;

import java.util.*;

/**
 * A directed graph consisting of vertices of type T.
 */
public class Graph<T> {
    private final Map<T, List<T>> adjacencyList = new HashMap<>();

    public Map<T, List<T>> getAdjacencyList() {
        return adjacencyList;
    }

    public int size() {
        return adjacencyList.size();
    }

    public Set<T> getVertices() {
        return adjacencyList.keySet();
    }

    public boolean contains(T vertex) {
        return adjacencyList.containsKey(vertex);
    }

    /**
     * Adds a vertex to the graph. The vertex will initially be
     * disconnected.
     *
     * @param vertex a vertex to add to the graph. It's illegal to add
     *        a vertex to the graph that is already present. Trying
     *        to do so will throw an {@link IllegalArgumentException}.
     */
    public void addVertex(T vertex) {
        if (contains(vertex)) {
            throw new IllegalArgumentException("Vertex is already present");
        } else {
            adjacencyList.put(vertex, new LinkedList<>());
        }
    }

    /**
     * Creates a connection between two vertices.
     *
     * @param from a vertex at the "from" end of a directed connection.
     *        The vertex must be added first using {@code #addVertex(T)}.
     * @param to a vertex at the "to" end of a directed connection. The
     *        vertex must be added first using {@code #addVertex(T)}.
     */
    public void addEdge(T from, T to) {
        if (!contains(from)) {
            addVertex(from);
        }
        if (!contains(to)) {
            addVertex(to);
        }
        adjacencyList.get(from).add(to);
    }
}
