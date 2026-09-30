package src.main.java.edu.udelp.Model;

import src.main.java.edu.udelp.queue.BooleanPriorityQueue;
import java.util.Scanner;

public class Editor {

    private static Scanner sc = new Scanner(System.in);
    private static BooleanPriorityQueue cola = new BooleanPriorityQueue<>();

    public static void main(String[] args) {
        int opcion = 0;

        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Por favor, ingresa un número válido.");
                sc.nextLine();
                continue;
            }




            System.out.println();

            switch (opcion) {
                case 1:
                    agregarPalabra();
                    break;
                case 2:
                    deshacerPalabra();
                    break;
                case 3:
                    eliminarPalabra();
                    break;
                case 4:
                    System.out.println("Saliendo del editor...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }

            System.out.println();

        } while (opcion != 4);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("======= Menú de editor =======");
        System.out.println("Elige la opción deseada:");
        System.out.println("1. Agregar palabra");
        System.out.println("2. Deshacer palabra");
        System.out.println("3. Eliminar palabra");
        System.out.println("4. Salir");
    }

    // ---------- Opción 1 ----------
    private static void agregarPalabra() {
        System.out.print("Ingresa la palabra: ");
        String palabra = sc.nextLine().trim();

        if (palabra.isEmpty()) {
            System.out.println("No se ingresó ninguna palabra.");
            return;
        }

        // Agregamos a la cola de prioridad
        cola.enqueue(palabra);
        System.out.println("Palabra \"" + palabra + "\" agregada correctamente.");
    }

    // ---------- Opción 2 ----------
    private static void deshacerPalabra() {
        if (cola.isEmpty()) {
            System.out.println("No hay palabras para deshacer.");
            return;
        }

        String palabraDeshecha = cola.dequeue();
        System.out.println("Palabra deshecha: " + palabraDeshecha);
    }

    // ---------- Opción 3 ----------
    private static void eliminarPalabra() {
        if (cola.isEmpty()) {
            System.out.println("No hay palabras en la cola para eliminar.");
            return;
        }

        String palabraEliminada = (String) cola.dequeue();
        System.out.println("Palabra \"" + palabraEliminada + "\" eliminada correctamente.");
    }
}

