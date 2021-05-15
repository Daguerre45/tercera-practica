package org.pr2;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.*;

public class GraphTest {

    Graph<Integer> gInts;

    @Before
    public void voidsetup() {
        gInts = new Graph<Integer>();
    }

    @Test
    public void graphExixstsTest() {
        assertNotNull(gInts);
    }

    @Test
    public void toStringTest() {
        gInts.addVertex(1);
        gInts.addVertex(2);
        String expectedOutupString = "Vertice\tConexiones\n" + "1\t\n" + "2\t\n";
        assertEquals((expectedOutupString), gInts.toString());
    }

    @Test
    public void addSingleVertexTest() {

        /*
         * gInts.addVertex(2); gInts.addVertex(3); gInts.addVertex(4);
         * gInts.addVertex(5); gInts.addVertex(6); gInts.addVertex(7);
         */
        assertTrue(gInts.addVertex(1));
        assertTrue(gInts.addVertex(2));
        assertTrue(gInts.addVertex(3));
        assertTrue(gInts.addVertex(4));
        assertTrue(gInts.addVertex(5));
        assertTrue(gInts.addVertex(6));
        assertTrue(gInts.addVertex(7));
    }

    @Test
    public void toStringSingleVertexTest() {
        gInts.addVertex(1);
        String expectedOutput = "Vertice\tConexiones\n" + "1\t\n";
        assertEquals(expectedOutput, gInts.toString());
    }

    @Test
    public void addSingleWrongVertex() {
        gInts.addVertex(2);
        gInts.addVertex(2);
        assertFalse(gInts.addVertex(2));
    }

    @Test
    public void addEdgeOk() {
        gInts.addVertex(1);
        gInts.addVertex(2);
        assertTrue(gInts.addEdge(1, 2));

    }

    @Test
    public void addEdgeFail() {
        gInts.addVertex(1);
        assertFalse(gInts.addEdge(1, 3));
    }

    @Test
    public void obtainAdjacentsTrue() throws Exception {
        gInts.addVertex(1);
        gInts.addVertex(2);
        gInts.addEdge(1, 2);
        gInts.obtainAdjacents(1);
        assertNotNull(gInts.obtainAdjacents(1));
    }

    @Test(expected = Exception.class)
    public void obtainAdjacentsFalse() throws Exception {
        this.gInts.obtainAdjacents(1);

    }

    @Test
    public void containsVertexTrue() {
        this.gInts.addVertex(1);
        assertTrue((gInts.containsVertex(1)));
    }

    @Test
    public void containsVertexFalse() {
        assertFalse(gInts.containsVertex(1));
    }

    /**
     * Este test comprueba que el método ‘onePath(V v1, V v2)‘ encuentra un camino
     * entre ‘v1‘ y ‘v2‘ cuando existe.
     */

    @Test
    public void onePathFindsAPath() {
        System.out.println("\nTest onePathFindsAPath");
        System.out.println("----------------------"); // Se construye el grafo.
        Graph<Integer> g = new Graph<>();
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4); // Se construye el caminoesperado.
        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(6);
        expectedPath.add(4); // Se comprueba si el camino devuelto es igual alesperado.
        assertEquals(expectedPath, g.onePath(1, 4));
    }

}
