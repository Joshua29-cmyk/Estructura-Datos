import java.util.Scanner;
public class OrdenamientoBurbuja {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] ventas = new int[10];

        System.out.println("=== SISTEMA DE VENTAS=====");
        // 1. Capturar datos
        capturarVentas(ventas);

        // 2. Mostrar arreglo original
        System.out.println("\nVentas originales:");
        mostrarArreglo(ventas);

        // 3. Ordenar arreglo usando Bubble Sort
        System.out.println("\nOrdenando...");
        ordenarBurbuja(ventas);

        // 4. Mostrar arreglo ordenado
        System.out.println("\nVentas ordenadas:");
        mostrarArreglo(ventas);

        // 5. Estadísticas
        // Al estar ordenado de menor a mayor, el índice 0 es la menor y el último es la mayor
        int ventaMasBaja = ventas[0];
        int ventaMasAlta = ventas[ventas.length - 1];
        double promedio = calcularPromedio(ventas);

        System.out.println("\nVenta más baja: " + ventaMasBaja);
        System.out.println("Venta más alta: " + ventaMasAlta);
        System.out.printf("Promedio de ventas: %.2f\n", promedio);
    }

    // Método para capturar las ventas de los 10 vendedores
    public static void capturarVentas(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Ingrese las ventas del vendedor " + (i + 1) + ": ");
            arreglo[i] = sc.nextInt();
        }
    }

    // Método para mostrar el contenido del arreglo en una sola línea
    public static void mostrarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    // Implementación manual del algoritmo Bubble Sort (Ordenamiento Burbuja)
    public static void ordenarBurbuja(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // Compara elementos adyacentes
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambio de posiciones (Swap)
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                }
            }
        }
    }

    // Método para calcular el promedio de los valores del arreglo
    public static double calcularPromedio(int[] arreglo) {
        int suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
        }
        return (double) suma / arreglo.length;
    }
}