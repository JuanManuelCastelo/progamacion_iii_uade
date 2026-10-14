import java.util.Arrays;

public class ParticionMitadesOptimizado {

    public static void particionMitadOptimizado(int[] v, int[] S, int E, int suma1, int suma2) {
        for (int i = 1; i <= 2; i++) {
            S[E] = i;

            // Actualizamos la suma correspondiente a la opción elegida
            int nuevaSuma1 = (i == 1) ? suma1 + v[E] : suma1;
            int nuevaSuma2 = (i == 2) ? suma2 + v[E] : suma2;

            if (E == v.length - 1) {
                // Directamente comparamos las sumas acumuladas
                if (nuevaSuma1 == nuevaSuma2) {
                    System.out.println("Solución encontrada con asignación: " + Arrays.toString(S));
                }
            } else {
                particionMitadOptimizado(v, S, E + 1, nuevaSuma1, nuevaSuma2);
            }
        }
    }

    public static void main(String[] args) {
        int[] v = {3, 5, 11, 9, 2};
        //int[] v = {3, 5, 11, 3, 2, 2, 2}; // Conjunto de entrada de prueba
        int[] S = new int[v.length];

        // Verificación rápida: Si la suma total es impar, no hay solución posible
        int sumaTotal = Arrays.stream(v).sum();
        if (sumaTotal % 2 != 0) {
            System.out.println("No existe partición: La suma total es impar (" + sumaTotal + ")");
            return;
        }

        particionMitadOptimizado(v, S, 0, 0, 0);
    }
}
