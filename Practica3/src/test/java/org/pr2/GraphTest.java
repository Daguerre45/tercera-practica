/**
 Copyright 2021 Alberto Daguerre Torres
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package org.pr2;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.*;

/**
 * Esta clase contiene todos los test que he ido creando para comprobar el buen
 * funcionamiento de mi clase Graph.
 * 
 * @author Alberto Daguerre
 * @version final 19/05/2021
 */

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
    public void addSingleVertexTest() {
        assertTrue(gInts.addVertex(1));
        assertTrue(gInts.addVertex(2));
        assertTrue(gInts.addVertex(3));
        assertTrue(gInts.addVertex(4));
        assertTrue(gInts.addVertex(5));
        assertTrue(gInts.addVertex(6));
        assertTrue(gInts.addVertex(7));
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

    @Test
    public void emptyToString() {
        String expexctedOutpuString = "Vertice\t Conexiones\n";
        assertEquals(expexctedOutpuString + "", gInts.toString());
    }

    @Test
    public void toStringVertex() {
        assertTrue(gInts.addVertex(1));
        String expectedOutputString = "Vertice\t Conexiones\n";
        assertEquals(expectedOutputString + "1[]\n", gInts.toString());
    }

    @Test
    public void toStringVertexFail() {
        assertTrue(gInts.addVertex(1));
        assertFalse(gInts.addVertex(1));
        String expectedOutputString = "Vertice\t Conexiones\n";
        assertEquals(expectedOutputString + "1[]\n", gInts.toString());
    }

    @Test
    public void toStringEdge() {
        assertTrue(gInts.addVertex(1));
        assertTrue(gInts.addVertex(2));
        assertTrue(gInts.addEdge(1, 2));
        String expectedOutputString = "Vertice\t Conexiones\n";
        assertEquals(expectedOutputString + "1[2]\n" + "2[]\n", gInts.toString());
    }

    @Test
    public void toStringEdgeFail() {
        assertTrue(gInts.addVertex(1));
        assertFalse(gInts.addEdge(1, 2));
        String expectedOutputString = "Vertice\t Conexiones\n";
        assertEquals(expectedOutputString + "1[]\n", gInts.toString());
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
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4); // Se construye el caminoesperado.
        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(6);
        expectedPath.add(4); // Se comprueba si el camino devuelto es igual al esperado.
        assertEquals(expectedPath, g.onePath(1, 4));
    }

}
