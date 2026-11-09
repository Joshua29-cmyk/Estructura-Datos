package src.main.java.edu.udelp.repaso.colas.Ejercicio1_TurnosBancarios;

import java.util.Scanner;
import src.main.java.edu.udelp.list.LinkedList;

public class MainClientes {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        LinkedList<Cliente> cola = new LinkedList<>();

        int opcion;

        do {
            System.out.println("\n--- TURNOS BANCARIOS ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Consultar siguiente");
            System.out.println("4. Mostrar pendientes");
            System.out.println("5. Cancelar turno");
            System.out.println("6. Contar clientes");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Numero de turno: ");
                    String turno = entrada.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = entrada.nextLine();

                    System.out.print("Tipo de tramite: ");
                    String tramite = entrada.nextLine();

                    Cliente nuevo = new Cliente(turno, nombre, tramite);

                    cola.add(cola.size(), nuevo);

                    System.out.println("Cliente registrado.");
                    break;

                case 2:
                    if (cola.isEmpty()) {
                        System.out.println("No hay clientes pendientes.");
                    } else {
                        System.out.println("Atendiendo: " + cola.remove(0));
                    }
                    break;

                case 3:
                    if (cola.isEmpty()) {
                        System.out.println("No hay clientes.");
                    } else {
                        System.out.println("Siguiente cliente: " + cola.get(0));
                    }
                    break;

                case 4:
                    if (cola.isEmpty()) {
                        System.out.println("La cola esta vacia.");
                    } else {
                        for (int i = 0; i < cola.size(); i++) {
                            System.out.println(cola.get(i));
                        }
                    }
                    break;

                case 5:
                    System.out.print("Turno a cancelar: ");
                    String cancelar = entrada.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < cola.size(); i++) {
                        if (cola.get(i).getTurno().equalsIgnoreCase(cancelar)) {
                            cola.remove(i);
                            encontrado = true;
                            break;
                        }
                    }

                    if (encontrado) {
                        System.out.println("Turno cancelado.");
                    } else {
                        System.out.println("Turno no encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Clientes pendientes: " + cola.size());
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
}
