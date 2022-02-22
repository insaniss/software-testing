package ru.ifmo.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static ru.ifmo.algorithm.Graph.*;

class GraphTest {
    private Graph<String> graph;

    @BeforeEach
    void setUp() {
        this.graph = new Graph<>();
    }

    private Scanner getScanner(String path) throws FileNotFoundException {
        return new Scanner(new BufferedInputStream(new FileInputStream(path)));
    }

    @ParameterizedTest(name = "in={0}, out={1}")
    @CsvFileSource(
            files = "lab-1.0/test/resources/paths.csv",
            numLinesToSkip = 1
    )
    void testDepthFirstTraversal(String inPath, String outPath)
            throws FileNotFoundException {

        final var in = getScanner(inPath);
        final var out = getScanner(outPath);

        final List<String> expected = new ArrayList<>();

        final var edgeCount = in.nextInt();
        for (var i = 0; i < edgeCount; i++) {
            graph.addEdge(in.next(), in.next());
        }
        final var vertexCount = out.nextInt();
        for (var i = 0; i < vertexCount; i++) {
            expected.add(out.next());
        }
        assertEquals(expected, depthFirstTraversal(graph, in.next()));
    }

    @ParameterizedTest(name = "startVertex = {0}")
    @NullAndEmptySource
    @ValueSource(strings = {
            "A",
            "ABC",
            "someVertex",
            "1"
    })
    void testDepthFirstTraversalWithThrowingIllegalArgumentException(String startVertex) {
        assertThrows(IllegalArgumentException.class, () -> depthFirstTraversal(graph, startVertex));
    }

    @ParameterizedTest(name = "vertex = {0}")
    @NullAndEmptySource
    @ValueSource(strings = {
            "O",
            "XYZ",
            "singleVertex",
            "999"
    })
    void testAddVertexWithThrowingIllegalArgumentException(String vertex) {
        assertThrows(IllegalArgumentException.class, () -> {
            graph.addVertex(vertex); graph.addVertex(vertex);
        });
    }
}
