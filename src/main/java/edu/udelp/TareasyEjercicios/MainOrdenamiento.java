package src.main.java.edu.udelp.TareasyEjercicios;
import java.util.Scanner;

public class MainOrdenamiento {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int[] numeros = null;
        int opcion;

        do {
            System.out.println("\n===== MENU DE ORDENAMIENTOS =====");
            System.out.println("1. Registrar numeros");
            System.out.println("2. Mostrar numeros");
            System.out.println("3. Ordenamiento por insercion");
            System.out.println("4. Ordenamiento por seleccion");
            System.out.println("5. QuickSort");
            System.out.println("6. ShellSort");
            System.out.println("7. Comparar algoritmos");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opcion: ");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Cuantos numeros deseas registrar: ");
                    int cantidad = entrada.nextInt();

                    numeros = new int[cantidad];

                    for (int i = 0; i < cantidad; i++) {
                        System.out.print("Numero " + (i + 1) + ": ");
                        numeros[i] = entrada.nextInt();
                    }

                    System.out.println("Numeros registrados correctamente.");
                    break;

                case 2:
                    if (numeros == null) {
                        System.out.println("Primero registra los numeros.");
                    } else {
                        mostrar(numeros);
                    }
                    break;

                case 3:
                    if (numeros != null) {
                        int[] insercion = numeros.clone();
                        ordenamientoInsercion(insercion);
                        System.out.println("Ordenamiento por insercion:");
                        mostrar(insercion);
                    } else {
                        System.out.println("Primero registra los numeros.");
                    }
                    break;

                case 4:
                    if (numeros != null) {
                        int[] seleccion = numeros.clone();
                        ordenamientoSeleccion(seleccion);
                        System.out.println("Ordenamiento por seleccion:");
                        mostrar(seleccion);
                    } else {
                        System.out.println("Primero registra los numeros.");
                    }
                    break;

                case 5:
                    if (numeros != null) {
                        int[] rapido = numeros.clone();
                        quickSort(rapido, 0, rapido.length - 1);
                        System.out.println("Ordenamiento QuickSort:");
                        mostrar(rapido);
                    } else {
                        System.out.println("Primero registra los numeros.");
                    }
                    break;

                case 6:
                    if (numeros != null) {
                        int[] shell = numeros.clone();
                        ordenamientoShell(shell);
                        System.out.println("Ordenamiento ShellSort:");
                        mostrar(shell);
                    } else {
                        System.out.println("Primero registra los numeros.");
                    }
                    break;

                case 7:
                    if (numeros != null) {
                        comparar(numeros);
                    } else {
                        System.out.println("Primero registra los numeros.");
                    }
                    break;

                case 8:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 8);

        entrada.close();
    }

    // Metodo para mostrar los numeros
    public static void mostrar(int[] numeros) {

        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        System.out.println();
    }

    // Ordenamiento por insercion
    public static void ordenamientoInsercion(int[] numeros) {

        for (int i = 1; i < numeros.length; i++) {

            int actual = numeros[i];
            int j = i - 1;

            while (j >= 0 && numeros[j] > actual) {
                numeros[j + 1] = numeros[j];
                j--;
            }

            numeros[j + 1] = actual;
        }
    }

    // Ordenamiento por seleccion
    public static void ordenamientoSeleccion(int[] numeros) {

        for (int i = 0; i < numeros.length - 1; i++) {

            int menor = i;

            for (int j = i + 1; j < numeros.length; j++) {

                if (numeros[j] < numeros[menor]) {
                    menor = j;
                }
            }

            int temporal = numeros[i];
            numeros[i] = numeros[menor];
            numeros[menor] = temporal;
        }
    }

    // QuickSort
    public static void quickSort(int[] numeros, int inicio, int fin) {

        if (inicio < fin) {

            int pivote = particion(numeros, inicio, fin);

            quickSort(numeros, inicio, pivote - 1);
            quickSort(numeros, pivote + 1, fin);
        }
    }

    public static int particion(int[] numeros, int inicio, int fin) {

        int pivote = numeros[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {

            if (numeros[j] <= pivote) {

                i++;

                int temporal = numeros[i];
                numeros[i] = numeros[j];
                numeros[j] = temporal;
            }
        }

        int temporal = numeros[i + 1];
        numeros[i + 1] = numeros[fin];
        numeros[fin] = temporal;

        return i + 1;
    }

    // Ordenamiento ShellSort
    public static void ordenamientoShell(int[] numeros) {

        int n = numeros.length;

        for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {

            for (int i = intervalo; i < n; i++) {

                int actual = numeros[i];
                int j = i;

                while (j >= intervalo &&
                        numeros[j - intervalo] > actual) {

                    numeros[j] = numeros[j - intervalo];
                    j -= intervalo;
                }

                numeros[j] = actual;
            }
        }
    }

    // Comparacion de los cuatro algoritmos
    public static void comparar(int[] numeros) {

        int[] insercion = numeros.clone();
        int[] seleccion = numeros.clone();
        int[] rapido = numeros.clone();
        int[] shell = numeros.clone();

        long inicio, fin;

        inicio = System.nanoTime();
        ordenamientoInsercion(insercion);
        fin = System.nanoTime();
        long tiempoInsercion = fin - inicio;

        inicio = System.nanoTime();
        ordenamientoSeleccion(seleccion);
        fin = System.nanoTime();
        long tiempoSeleccion = fin - inicio;

        inicio = System.nanoTime();
        quickSort(rapido, 0, rapido.length - 1);
        fin = System.nanoTime();
        long tiempoQuick = fin - inicio;

        inicio = System.nanoTime();
        ordenamientoShell(shell);
        fin = System.nanoTime();
        long tiempoShell = fin - inicio;

        System.out.println("\n===== COMPARACION DE ALGORITMOS =====");

        System.out.println("Insercion: " + tiempoInsercion + " nanosegundos");
        System.out.println("Seleccion: " + tiempoSeleccion + " nanosegundos");
        System.out.println("QuickSort: " + tiempoQuick + " nanosegundos");
        System.out.println("ShellSort: " + tiempoShell + " nanosegundos");

        System.out.println("\nResultados ordenados:");

        System.out.print("Insercion: ");
        mostrar(insercion);

        System.out.print("Seleccion: ");
        mostrar(seleccion);

        System.out.print("QuickSort: ");
        mostrar(rapido);

        System.out.print("ShellSort: ");
        mostrar(shell);


    }
}
