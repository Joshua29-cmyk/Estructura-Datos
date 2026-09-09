import java.util.Scanner;
public class OrdenamientoBurbuja {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] ventas = new int[10];
        System.out.println("=== SISTEMA DE VENTAS ===");
        
        //  Capturar los datos de cada vendedor
        capturarVentas(ventas);
        // 2. Mostrar arreglo original
        System.out.println("\nVentas originales:");
        mostrarArreglo(ventas);
        //  Ordenar arreglo usando el posicionamiento burbuja 
        System.out.println("\nOrdenando...");
        ordenarBurbuja(ventas);
        //  Mostrar el arreglo ya ordenado
        System.out.println("\nVentas ordenadas:");
        mostrarArreglo(ventas);
        //  Estadísticas finales de las ventas finales, la venta más baja, la venta más alta y el promedio de ventas
        // Al poder estar ordenado de menor a mayor, el índice 0 es la menor y el último es la mayor
        int ventaMasBaja = ventas[0];
        int ventaMasAlta = ventas[ventas.length - 1];
        double promedio = calcularPromedio(ventas);
        System.out.println("\nVenta más baja: " + ventaMasBaja);
        System.out.println("Venta más alta: " + ventaMasAlta);
        System.out.printf("Promedio de ventas: %.2f\n", promedio);
    }
    // Método para capturar las ventas de los 10 vendedores
    // No se permiten valores negativos
    public static void capturarVentas(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            int valor = -1;
            boolean valido = false;

            while (!valido) {
                System.out.print("Ingrese las ventas del vendedor " + (i + 1) + ": ");
                valor = sc.nextInt();

                if (valor < 0) {
                    System.out.println("Error: la venta no puede ser negativa. Intente de nuevo.");
                } else {
                    valido = true;
                }
            }

            arreglo[i] = valor;
        }
    }
    // Método para mostrar el contenido del arreglo en una sola línea
    public static void mostrarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }
    // Inicio del metodo de burbuja 
    public static void ordenarBurbuja(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // Compara los elementos adyacentes
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambio de posiciones 
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                }
            }
        }
    }
    // Método para poder calcular el promedio de los valores del arreglo
    public static double calcularPromedio(int[] arreglo) {
        int suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
        }
        return (double) suma / arreglo.length;
    }
}