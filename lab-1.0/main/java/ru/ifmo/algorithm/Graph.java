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
     * @param source a vertex at the "source" end of a directed connection.
     *        The vertex must be added first using {@code #addVertex(T)}.
     * @param destination a vertex at the "destination" end of a directed connection.
     *        The vertex must be added first using {@code #addVertex(T)}.
     */
    public void addEdge(T source, T destination) {
        if (!contains(source)) {
            addVertex(source);
        }
        if (!contains(destination)) {
            addVertex(destination);
        }
        adjacencyList.get(source).add(destination);
    }

    /**
     * Returns a {@code List} over the vertices reachable from <i>start</i>,
     * in the order of a depth-first traversal.
     *
     * @param graph {@code Graph} representing a graph that may have cycles.
     * @param start a vertex of type T to start the traversal. It's illegal
     *        if it's not present. Trying to do so will  throw an
     *        {@link IllegalArgumentException}.
     * @return the list over the vertices in order of a depth-first traversal.
     */
    public static <T> List<T> depthFirstTraversal(Graph<T> graph,
                                                  T start) {
        List<T> vertices = new ArrayList<>(graph.size());
        if (!graph.contains(start)) {
            throw new IllegalArgumentException("Vertex is not an element of the graph");
        } else {
            depthFirstTraversal(graph, start, vertices);
        }
        return vertices;
    }

    /* A recursive function used by another one */
    private static <T> void depthFirstTraversal(Graph<T> graph,
                                                T start,
        /* mark as visited */                   List<T> vertices) {
        vertices.add(start);
        for (T vertex : graph.getAdjacencyList().get(start)) {
            if (!vertices.contains(vertex)) {
                depthFirstTraversal(graph, vertex, vertices);
            }
        }
    }
}
