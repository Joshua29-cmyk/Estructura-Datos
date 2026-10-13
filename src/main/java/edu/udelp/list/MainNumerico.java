package src.main.java.edu.udelp.list;

import java.util.Scanner;

public class MainNumerico {

    // Copio mi lista para no modificar los números originales
    public static ArrayList<Integer> copiar(ArrayList<Integer> lista) {
        ArrayList<Integer> copia = new ArrayList<>(lista.size() + 1, 5);

        for (int i = 0; i < lista.size(); i++) {
            copia.add(lista.get(i));
        }

        return copia;
    }

    // Ordenamiento por inserción
    public static ArrayList<Integer> insercion(ArrayList<Integer> lista) {
        ArrayList<Integer> arreglo = copiar(lista);

        for (int i = 1; i < arreglo.size(); i++) {
            int actual = arreglo.get(i);
            int j = i - 1;

            // Muevo los números mayores hacia la derecha
            while (j >= 0 && arreglo.get(j) > actual) {
                arreglo.set(j + 1, arreglo.get(j));
                j--;
            }

            arreglo.set(j + 1, actual);
        }

        return arreglo;
    }

    // Ordenamiento por selección
    public static ArrayList<Integer> seleccion(ArrayList<Integer> lista) {
        ArrayList<Integer> arreglo = copiar(lista);

        for (int i = 0; i < arreglo.size() - 1; i++) {
            int menor = i;

            // Busco el número más pequeño
            for (int j = i + 1; j < arreglo.size(); j++) {
                if (arreglo.get(j) < arreglo.get(menor)) {
                    menor = j;
                }
            }

            // Intercambio los números de posición
            int temporal = arreglo.get(i);
            arreglo.set(i, arreglo.get(menor));
            arreglo.set(menor, temporal);
        }

        return arreglo;
    }

    // Ordenamiento QuickSort
    public static ArrayList<Integer> quickSort(ArrayList<Integer> lista) {
        ArrayList<Integer> arreglo = copiar(lista);

        if (!arreglo.isEmpty()) {
            ordenarRapido(arreglo, 0, arreglo.size() - 1);
        }

        return arreglo;
    }

    // Divido mi arreglo usando un pivote
    private static void ordenarRapido(
            ArrayList<Integer> arreglo, int izquierda, int derecha) {

        int i = izquierda;
        int j = derecha;
        int pivote = arreglo.get((izquierda + derecha) / 2);

        while (i <= j) {

            while (arreglo.get(i) < pivote) {
                i++;
            }

            while (arreglo.get(j) > pivote) {
                j--;
            }

            if (i <= j) {
                int temporal = arreglo.get(i);
                arreglo.set(i, arreglo.get(j));
                arreglo.set(j, temporal);

                i++;
                j--;
            }
        }

        if (izquierda < j) {
            ordenarRapido(arreglo, izquierda, j);
        }

        if (i < derecha) {
            ordenarRapido(arreglo, i, derecha);
        }
    }



    // Ordenamiento ShellSort
    public static ArrayList<Integer> shellSort(ArrayList<Integer> lista) {
        ArrayList<Integer> arreglo = copiar(lista);

        int salto = arreglo.size() / 2;

        while (salto > 0) {

            for (int i = salto; i < arreglo.size(); i++) {
                int actual = arreglo.get(i);
                int j = i;

                // Comparo elementos separados por el salto
                while (j >= salto
                        && arreglo.get(j - salto) > actual) {
                    arreglo.set(j, arreglo.get(j - salto));
                    j -= salto;
                }

                arreglo.set(j, actual);
            }

            salto /= 2;
        }

        return arreglo;
    }

    // Registro los números que ingresa el usuario
    public static void registrar(
            Scanner entrada, ArrayList<Integer> lista) {

        int cantidad;

        do {
            System.out.print("¿Cuántos números deseas registrar? ");
            cantidad = entrada.nextInt();

            if (cantidad <= 0) {
                System.out.println("Ingresa una cantidad mayor que cero.");
            }

        } while (cantidad <= 0);

        // Registro los números en mi lista
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingresa el número " + (i + 1) + ": ");
            lista.add(entrada.nextInt());
        }

        System.out.println("Números registrados correctamente.");
    }

    // Ejecuto un algoritmo y mido su tiempo
    public static void ejecutar(
            String nombre, ArrayList<Integer> lista, int opcion) {

        long inicio = System.nanoTime();
        ArrayList<Integer> resultado;

        if (opcion == 1) {
            resultado = insercion(lista);
        } else if (opcion == 2) {
            resultado = seleccion(lista);
        } else if (opcion == 3) {
            resultado = quickSort(lista);
        } else {
            resultado = shellSort(lista);
        }

        long fin = System.nanoTime();

        System.out.println("\nMétodo: " + nombre);
        System.out.println("Lista ordenada: " + resultado);
        System.out.println("Tiempo: " + (fin - inicio) + " nanosegundos");
    }

    // Muestro el submenú de ordenamiento
    public static void mostrarYOrdenar(
            Scanner entrada, ArrayList<Integer> lista) {

        if (lista.isEmpty()) {
            System.out.println("Primero debes registrar números.");
            return;
        }

        int opcion;

        do {
            System.out.println("\n--- ORDENAR NÚMEROS ---");
            System.out.println("Lista original: " + lista);
            System.out.println("1. Ordenar por inserción");
            System.out.println("2. Ordenar por selección");
            System.out.println("3. Ordenar por QuickSort");
            System.out.println("4. Ordenar por ShellSort");
            System.out.println("5. Regresar al menú principal");
            System.out.print("Elige una opción: ");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    ejecutar("Inserción", lista, 1);
                    break;

                case 2:
                    ejecutar("Selección", lista, 2);
                    break;

                case 3:
                    ejecutar("QuickSort", lista, 3);
                    break;

                case 4:
                    ejecutar("ShellSort", lista, 4);
                    break;

                case 5:
                    System.out.println("Regresando al menú principal...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
    }

    // Comparo los cuatro algoritmos con los mismos números
    public static void compararTodos(ArrayList<Integer> lista) {

        if (lista.isEmpty()) {
            System.out.println("Primero debes registrar números.");
            return;
        }

        System.out.println("\n--- COMPARACIÓN DE ALGORITMOS ---");
        System.out.println("Lista original: " + lista);

        ejecutar("Inserción", lista, 1);
        ejecutar("Selección", lista, 2);
        ejecutar("QuickSort", lista, 3);
        ejecutar("ShellSort", lista, 4);
    }

    // Inicio mi programa y muestro el menú principal
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Creo mi lista personalizada
        ArrayList<Integer> lista = new ArrayList<>(5, 5);

        int opcion;

        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Registrar números");
            System.out.println("2. Mostrar y ordenar números");
            System.out.println("3. Comparar los cuatro algoritmos");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    registrar(entrada, lista);
                    System.out.println("Lista actual: " + lista);
                    break;

                case 2:
                    mostrarYOrdenar(entrada, lista);
                    break;

                case 3:
                    compararTodos(lista);
                    break;

                case 4:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);

        entrada.close();
    }
}


