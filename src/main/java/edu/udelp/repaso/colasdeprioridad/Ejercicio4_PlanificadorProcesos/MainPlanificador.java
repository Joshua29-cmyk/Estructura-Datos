package src.main.java.edu.udelp.repaso.colasdeprioridad.Ejercicio4_PlanificadorProcesos;

import java.util.Scanner;
import src.main.java.edu.udelp.list.LinkedList;

public class MainPlanificador {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        LinkedList<Proceso> cola = new LinkedList<>();
        LinkedList<String> historial = new LinkedList<>();

        int opcion;

        do {
            System.out.println("\n=== PLANIFICADOR DE PROCESOS ===");
            System.out.println("1. Registrar proceso");
            System.out.println("2. Ejecutar turno");
            System.out.println("3. Mostrar procesos pendientes");
            System.out.println("4. Mostrar historial");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("ID del proceso: ");
                    String id = entrada.nextLine();

                    System.out.print("Prioridad (1 es mayor): ");
                    int prioridad = entrada.nextInt();

                    System.out.print("Ciclos pendientes: ");
                    int ciclos = entrada.nextInt();
                    entrada.nextLine();

                    if (prioridad < 1 || ciclos <= 0) {
                        System.out.println("Datos no validos.");
                        break;
                    }

                    Proceso nuevo = new Proceso(id, prioridad, ciclos);

                    insertarOrdenado(cola, nuevo);

                    System.out.println("Proceso registrado.");
                    break;

                case 2:
                    if (cola.isEmpty()) {
                        System.out.println("No hay procesos pendientes.");
                    } else {
                        Proceso proceso = cola.remove(0);

                        int ejecutar = Math.min(3, proceso.getCiclos());

                        proceso.ejecutar(ejecutar);

                        String registro = proceso.getId() +
                                " ejecuto " + ejecutar + " ciclos.";

                        historial.add(historial.size(), registro);

                        System.out.println(registro);

                        if (proceso.getCiclos() > 0) {
                            insertarOrdenado(cola, proceso);
                            System.out.println("Proceso pendiente: "
                                    + proceso.getCiclos() + " ciclos.");
                        } else {
                            System.out.println("Proceso finalizado.");
                        }
                    }
                    break;

                case 3:
                    if (cola.isEmpty()) {
                        System.out.println("No hay procesos pendientes.");
                    } else {
                        for (int i = 0; i < cola.size(); i++) {
                            System.out.println(cola.get(i));
                        }
                    }
                    break;

                case 4:
                    if (historial.isEmpty()) {
                        System.out.println("No hay historial.");
                    } else {
                        for (int i = 0; i < historial.size(); i++) {
                            System.out.println(historial.get(i));
                        }
                    }
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        entrada.close();
    }

    // Inserto el proceso respetando la prioridad y el orden de ingreso.
    public static void insertarOrdenado(
            LinkedList<Proceso> cola, Proceso nuevo) {

        int posicion = 0;

        while (posicion < cola.size()) {

            if (nuevo.getPrioridad() < cola.get(posicion).getPrioridad()) {
                break;
            }

            posicion++;
        }

        cola.add(posicion, nuevo);
    }
}