package org.pr2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jdk.jfr.Timestamp;

/**
 * Unit test for simple App.
 */
public class GraphTest {
    /**
     * Este test comprueba que el método ‘onePath(V v1, V v2)‘ encuentra un camino
     * entre ‘v1‘ y ‘v2‘ cuando existe.
     */

    Graph<Integer> gInts;
    

    @Before
    public voidsetup(){
        gInts = new Graph<Integer> ;
    }

    @Test
    public void graphExixstsTest(){
        assertNotNull(true);
    }

    @Test
    public void toStringEmptyTest(){
        String expectedOutputs = "Vertice\tConexiones\n";
        assertEquals(expectedOutputs,gInts.toString());
    }

    @Test 
    public void toStringSingleVertexTest(){
        gInts.addVertex(1);
        String expectedOutput = "Vertice\tConexiones\n" + "1\t\n" ;
        assertEquals(expectedOutput,gInts.toString());

    }

    @Test 
    public void addSingleVertexTest(){
        gInts.addVertex(1);
        assertTrue(gInts.addVertex(1));
    }

    @Test
    public void onePathFindsAPath() {
        System.out.println("\nTest onePathFindsAPath");
        System.out.println("----------------------");
        // Se construye el grafo.
        Graph<Integer> g = new Graph<>();
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
        // Se construye el camino esperado.
        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(6);
        expectedPath.add(4);
        // Se comprueba si el camino devuelto es igual al esperado.
        assertEquals(expectedPath, g.onePath(1, 4));
    }
}
