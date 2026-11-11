
package src.main.java.edu.udelp.TareasyEjercicios;

import java.util.Scanner;

public class MainPrioridadNumerica {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);


        int opcion;

        do {
            System.out.println("\n==== PRIORIDAD NUMÉRICA ====");
            System.out.println("1. Agregar número");
            System.out.println("2. Atender número");
            System.out.println("3. Mostrar cola");
            System.out.println("4. Mostrar cantidad");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingresa el número: ");
                    int numero = entrada.nextInt();

                    System.out.println("1. Alta");
                    System.out.println("2. Media");
                    System.out.println("3. Baja");
                    System.out.print("Ingresa la prioridad: ");

                    int prioridad = entrada.nextInt();

                    if (prioridad >= 1 && prioridad <= 3) {
                        cola.add(numero, prioridad);
                        System.out.println("Número agregado correctamente.");
                    } else {
                        System.out.println("Prioridad inválida. Debe ser 1, 2 o 3.");
                    }
                    break;

                case 2:
                    if (!cola.isEmpty()) {
                        int atendido = cola.remove();
                        System.out.println("Número atendido: " + atendido);
                    } else {
                        System.out.println("La cola está vacía.");
                    }
                    break;

                case 3:
                    cola.mostrar();
                    break;

                case 4:
                    System.out.println("Números pendientes: " + cola.size());
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }

        } while (opcion != 5);

        entrada.close();


    }
}

