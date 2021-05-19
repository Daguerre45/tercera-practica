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

import java.util.*;

/**
 * Esta clase contiene todo lo necesario pada poder crear en base al genérico
 * 'V' Vértices en un grafo; Ejes que unen los vértices y Los adjacentes a mis
 * vértices;
 * 
 * @author Alberto Daguerre
 * @version final 19/05/2021
 */

public class Graph<V> {
    // Lista de adyacencia.

    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    /******************************************************************
     * Añade el vértice ‘v‘ al grafo. Complejidad espacial O(1). Complejidad
     * temporal O(1).
     * 
     * @param v
     *
     * @param v vértice a añadir.
     * @return ‘true‘ si no estaba anteriormente y ‘false‘ en caso * contrario.
     ******************************************************************/

    public boolean addVertex(V v) {
        if (!this.adjacencyList.containsKey(v)) {
            this.adjacencyList.put(v, new TreeSet<V>());
            return true;
        } else
            return false;
    }

    /******************************************************************
     * Añade un arco entre los vértices ‘v1‘ y ‘v2‘ al grafo. En caso de que no
     * exista alguno de los vértices, lo añade también. Complejidad espacial O(1).
     * Complejidad temporal O(1).
     *
     * @param v1 el origen del arco.
     * @param v2 el destino del arco.
     * @return ‘true‘ si no existía el arco y ‘false‘ en caso contrario.
     ******************************************************************/

    public boolean addEdge(V v1, V v2) {
        Set<V> adjacentesAMiVertice = this.adjacencyList.get(v1);
        if (this.adjacencyList.containsKey(v1) && this.adjacencyList.containsKey(v2)
                && !adjacentesAMiVertice.contains(v2)) {
            adjacentesAMiVertice.add(v2);
            return true;
        } else
            return false;
    }

    /******************************************************************
     * Obtiene el conjunto de vértices adyacentes a ‘v‘. Complejidad espacial
     * 0(1).Complejidad temporal O(1).
     *
     * @param v vértice del que se obtienen los adyacentes.
     * @return conjunto de vértices adyacentes.
     ******************************************************************/

    public Set<V> obtainAdjacents(V v) throws Exception {
        if (this.adjacencyList.containsKey(v)) {
            return this.adjacencyList.get(v);
        } else
            throw new Exception("No existe ningún vértice adjacente a ese punto"); // Este código hay que modificarlo.
    }

    /******************************************************************
     * Comprueba si el grafo contiene el vértice dado.Complejidad espacial
     * O(1).Complejidad temporal O(1).
     *
     * @param v vértice para el que se realiza la comprobación.
     * @return ‘true‘ si ‘v‘ es un vértice del grafo.
     ******************************************************************/

    public boolean containsVertex(V v) {
        if (this.adjacencyList.containsKey(v)) {
            return true;
        } else
            return false; // Este código hay que modificarlo.
    }

    /******************************************************************
     * Método ‘toString()‘ reescrito para la clase ‘Grafo.java‘. Complejidad
     * espacial O(1). Complejidad temporal O(n).
     * 
     * @return una cadena de caracteres con la lista de adyacencia .
     ******************************************************************/
    @Override
    public String toString() {
        StringBuilder serie = new StringBuilder();
        serie.append("Vertice\t Conexiones\n");
        for (Object key : this.adjacencyList.keySet()) {
            serie.append(key.toString());
            serie.append(this.adjacencyList.get(key).toString() + "\n");
        }

        return serie.toString();
    }

    /******************************************************************
     * Obtiene, en caso de que exista, un camino entre ‘v1‘ y ‘v2 ‘. En caso
     * contrario, devuelve ‘null‘. Complejidad espacial O(1). Complejidad Temporal
     * (n^2).
     *
     * @param v1 el vértice origen.
     * @param v2 el vértice destino.
     * @return lista con la secuencia de vértices desde ‘v1‘ hasta ‘v2‘ pasando por
     *         arcos del grafo.
     ******************************************************************/

    public List<V> onePath(V v1, V v2) {
        Stack<V> pila = new Stack<>();
        List<V> traza = new ArrayList<>();
        boolean encontrado = false;
        pila.push(v1);
        while (!pila.isEmpty() && !encontrado) {
            V viajero = pila.pop();
            traza.add(viajero);
            if (!viajero.equals(v2)) {
                for (V adjacentesViajero : adjacencyList.get(viajero)) {
                    pila.push(adjacentesViajero);
                }
            } else
                encontrado = true;
        }

        if (encontrado) {
            return traza;
        } else
            return null;

    }
}