package org.pr2;

import java.util.*;

public class Graph<V> {
    // Lista de adyacencia.

    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    /******************************************************************
     * Añade el vértice ‘v‘ al grafo.
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
     * exista alguno de los vértices, lo añade también.
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
     * Obtiene el conjunto de vértices adyacentes a ‘v‘.
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
     * Comprueba si el grafo contiene el vértice dado.
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
     * Método ‘toString()‘ reescrito para la clase ‘Grafo.java‘.
     * 
     * @return una cadena de caracteres con la lista de adyacencia .
     ******************************************************************/
    @Override
    public String toString() {
        StringBuilder serie = new StringBuilder();
        serie.append("Vertice\tConexiones\n");
        for (Object key : this.adjacencyList.keySet()) {
            serie.append(key.toString() + "\t" + "\n");
        }

        return serie.toString();
    }

    /******************************************************************
     * Obtiene, en caso de que exista, un camino entre ‘v1‘ y ‘v2 ‘. En caso
     * contrario, devuelve ‘null‘.
     *
     * @param v1 el vértice origen.
     * @param v2 el vértice destino.
     * @return lista con la secuencia de vértices desde ‘v1‘ hasta ‘v2‘ pasando por
     *         arcos del grafo.
     ******************************************************************/

    public List<V> onePath(V v1, V v2) {
        Stack<V> abierta = new Stack<>();
        List<V> traza = new ArrayList<>();
        boolean encontrado = false;
        Set<V> visitados = new HashSet<>();
        abierta.push(v1);
        traza.add(v1);

        while (!abierta.isEmpty() && !encontrado) {
            V viajero = abierta.pop();
            if (viajero.equals(v2)) {
                for (V adjacentesViajero : adjacencyList.get(viajero)) {
                    if (viajero.equals(v2)) {
                        encontrado = true;

                    } else {
                        for (V adjacentesAnnadir : adjacencyList.get(viajero)) {
                            abierta.push(adjacentesAnnadir);
                        }

                    }
                }
            }
        }
        if (encontrado) {
            return traza;
        } else
            return null;

    }
}