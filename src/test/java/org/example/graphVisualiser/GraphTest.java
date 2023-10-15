package org.example.graphVisualiser;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphTest {
    @Test
    public void testGraphCreation() {
        Graph graph = new Graph();
        Main.Human a = new Main.Human("A");
        graph.addVertex(a);
        assertTrue(graph.isInGraph(a));
        Main.Human b = new Main.Human("B");
        graph.addVertex(b);

        graph.addEdge(a, b);

        assertTrue(graph.isConnected(a, b));

        assertFalse(graph.isConnected(new Main.Human("XZ"), a));

    }
}
