package src.main.java.edu.udelp.repaso.colasdeprioridad.Ejercicio3_UrgenciasMedicas;

import java.util.Scanner;
import src.main.java.edu.udelp.list.LinkedList;

public class MainUrgencias {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        LinkedList<Paciente> cola = new LinkedList<>();

        int contadorLlegada = 1;
        int opcion;

        do {
            System.out.println("\n--- ATENCION DE URGENCIAS ---");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Atender paciente");
            System.out.println("3. Modificar prioridad");
            System.out.println("4. Mostrar orden de atencion");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String nombre = entrada.nextLine();

                    System.out.print("Edad: ");
                    int edad = entrada.nextInt();

                    System.out.print("Prioridad (1-5): ");
                    int prioridad = entrada.nextInt();
                    entrada.nextLine();

                    if (prioridad < 1 || prioridad > 5) {
                        System.out.println("Prioridad no valida.");
                        break;
                    }

                    Paciente nuevo = new Paciente(
                            nombre, edad, prioridad, contadorLlegada++);

                    insertarOrdenado(cola, nuevo);

                    System.out.println("Paciente registrado.");
                    break;

                case 2:
                    if (cola.isEmpty()) {
                        System.out.println("No hay pacientes.");
                    } else {
                        System.out.println("Atendiendo: " + cola.remove(0));
                    }
                    break;

                case 3:
                    System.out.print("Nombre del paciente: ");
                    String buscar = entrada.nextLine();

                    int posicion = -1;

                    for (int i = 0; i < cola.size(); i++) {
                        if (cola.get(i).getNombre().equalsIgnoreCase(buscar)) {
                            posicion = i;
                            break;
                        }
                    }

                    if (posicion == -1) {
                        System.out.println("Paciente no encontrado.");
                    } else {
                        Paciente paciente = cola.remove(posicion);

                        System.out.print("Nueva prioridad (1-5): ");
                        int nuevaPrioridad = entrada.nextInt();
                        entrada.nextLine();

                        if (nuevaPrioridad < 1 || nuevaPrioridad > 5) {
                            insertarOrdenado(cola, paciente);
                            System.out.println("Prioridad no valida.");
                        } else {
                            paciente.setPrioridad(nuevaPrioridad);
                            insertarOrdenado(cola, paciente);
                            System.out.println("Prioridad modificada.");
                        }
                    }
                    break;

                case 4:
                    if (cola.isEmpty()) {
                        System.out.println("No hay pacientes registrados.");
                    } else {
                        for (int i = 0; i < cola.size(); i++) {
                            System.out.println(cola.get(i));
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

    // Inserto según prioridad y respeto el orden de llegada.
    public static void insertarOrdenado(
            LinkedList<Paciente> cola, Paciente nuevo) {

        int posicion = 0;

        while (posicion < cola.size()) {

            Paciente actual = cola.get(posicion);

            if (nuevo.getPrioridad() < actual.getPrioridad()) {
                break;
            }

            if (nuevo.getPrioridad() == actual.getPrioridad()
                    && nuevo.getLlegada() < actual.getLlegada()) {
                break;
            }

            posicion++;
        }

        cola.add(posicion, nuevo);
    }
}
