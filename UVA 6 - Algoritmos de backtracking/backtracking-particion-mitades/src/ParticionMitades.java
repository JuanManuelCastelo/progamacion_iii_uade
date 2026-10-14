import java.util.Arrays;

public class ParticionMitades {

    public static void particionMitad(int[] v, int[] S, int E) {
        // Asignar el elemento actual al subconjunto 1 o al 2
        for (int i = 1; i <= 2; i++) {
            S[E] = i; // S[E] <- i

            // Si llegamos al último elemento (E == v.length - 1)
            if (E == v.length - 1) {
                int suma1 = 0;
                int suma2 = 0;

                // Calcular la suma para cada subconjunto
                for (int j = 0; j < v.length; j++) {
                    if (S[j] == 1) {
                        suma1 += v[j];
                    } else {
                        suma2 += v[j];
                    }
                }

                // Si las sumas son iguales, mostramos la solución
                if (suma1 == suma2) {
                    mostrarSolucion(v, S);
                }
            } else {
                // Caso recursivo: avanzar al siguiente elemento
                particionMitad(v, S, E + 1);
            }
        }
    }

    private static void mostrarSolucion(int[] v, int[] S) {
        System.out.println("----------------------------------------");
        System.out.println("¡Partición válida encontrada!");
        System.out.print("Subconjunto 1: [ ");
        for (int i = 0; i < v.length; i++) {
            if (S[i] == 1) System.out.print(v[i] + " ");
        }
        System.out.println("]");

        System.out.print("Subconjunto 2: [ ");
        for (int i = 0; i < v.length; i++) {
            if (S[i] == 2) System.out.print(v[i] + " ");
        }
        System.out.println("]\nAsignación S: " + Arrays.toString(S));
    }

    public static void main(String[] args) {
        //int[] v = {9, 2, 3, 4}; // Conjunto de entrada de prueba
        int[] v = {3, 5, 11, 9, 2, 2};// Conjunto de entrada de prueba
        int[] S = new int[v.length];

        System.out.println("Buscando particiones en mitades para: " + Arrays.toString(v));
        particionMitad(v, S, 0);
    }
}