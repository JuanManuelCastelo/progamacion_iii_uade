import java.util.*;

public class BusquedaEnProfundidad {

    /**
     * Algoritmo de Búsqueda en Profundidad (DFS)
     *
     * @param grafo     Representación del grafo (Lista de adyacencia)
     * @param v         Vértice inicial/actual
     * @param visitados Conjunto de nodos ya visitados
     */
    public static void busquedaEnProfundidad(Map<Character, List<Character>> grafo, char v, Set<Character> visitados) {
        // AgregarElemento(visitados, v)
        visitados.add(v);

        // Imprimir(v)
        System.out.print(v + " ");

        // ady <- Adyacentes(G, v)
        List<Character> ady = new ArrayList<>(grafo.getOrDefault(v, Collections.emptyList()));

        // mientras ady != Ø
        while (!ady.isEmpty()) {
            // a <- Elegir(ady)
            // Sacar(ady, a)
            char a = ady.remove(0); // Toma y remueve el primer adyacente

            // si (!Pertenece(visitados, a))
            if (!visitados.contains(a)) {
                // BusquedaEnProfundidad(G, a, visitados)
                busquedaEnProfundidad(grafo, a, visitados);
            }
        }
    }

    public static void main(String[] args) {
        // Construcción del grafo de ejemplo que figura en la diapositiva 4 del PDF
        Map<Character, List<Character>> grafo = new LinkedHashMap<>();
        grafo.put('A', Arrays.asList('B', 'E', 'F', 'C'));
        grafo.put('B', Arrays.asList('E', 'D'));
        grafo.put('C', Collections.emptyList());
        grafo.put('D', Arrays.asList('C'));
        grafo.put('E', Arrays.asList('C', 'F'));
        grafo.put('F', Arrays.asList('C'));

        Set<Character> visitados = new HashSet<>();

        System.out.println("--- Recorrido en Profundidad comenzando desde 'A' ---");
        busquedaEnProfundidad(grafo, 'B', visitados);
        System.out.println();
    }
}
