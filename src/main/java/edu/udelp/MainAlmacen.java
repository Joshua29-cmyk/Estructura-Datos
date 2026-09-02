package src.main.java.edu.udelp;

import edu.udelp.Model.Paqueteria;
import edu.udelp.Stack.StackPaqueteria;

import java.util.Scanner;

public class MainAlmacen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StackPaqueteria almacen = new StackPaqueteria();
        int opcion;

        do {
            System.out.println("\n========= BIENVENIDO AL ALMACÉN =========");
            System.out.println("1. Registrar paquete");
            System.out.println("2. Retirar paquete");
            System.out.println("3. Consultar siguiente paquete");
            System.out.println("4. Mostrar paquetes");
            System.out.println("5. Buscar paquete");
            System.out.println("6. Salir");
            System.out.print("\nSelecciona una opción: ");

            opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                    registrarPaquete(sc, almacen);
                    break;
                case 2:
                    retirarPaquete(almacen);
                    break;
                case 3:
                    consultarSiguiente(almacen);
                    break;
                case 4:
                    almacen.mostrar();
                    break;
                case 5:
                    buscarPaquete(sc, almacen);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }

        } while (opcion != 6);

        sc.close();
    }

    private static void registrarPaquete(Scanner sc, StackPaqueteria almacen) {
        System.out.print("ID del paquete: ");
        int id = leerEntero(sc);

        if (almacen.buscar(id) != null) {
            System.out.println("Ya existe un paquete registrado con el ID " + id + ".");
            return;
        }

        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();

        System.out.print("Peso del paquete(kg): ");
        double peso = leerDouble(sc);

        Paqueteria paquete = new Paqueteria(id, descripcion, peso);
        almacen.push(paquete);
        System.out.println("Paquete registrado correctamente en el almacén.");
    }

    private static void retirarPaquete(StackPaqueteria almacen) {
        Paqueteria retirado = almacen.pop();
        if (retirado != null) {
            System.out.println("Paquete retirado:");
            System.out.println(retirado);
        }
    }

    private static void consultarSiguiente(StackPaqueteria almacen) {
        Paqueteria siguiente = almacen.peek();
        if (siguiente != null) {
            System.out.println("El siguiente paquete a retirar es:");
            System.out.println(siguiente);
        }
    }

    private static void buscarPaquete(Scanner sc, StackPaqueteria almacen) {
        System.out.print("ID a buscar: ");
        int id = leerEntero(sc);

        Paqueteria encontrado = almacen.buscar(id);
        if (encontrado != null) {
            System.out.println("\nPaquete encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("\nNo existe un paquete con el ID " + id + ".");
        }
    }

    private static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa un número válido: ");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    private static double leerDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Ingresa un número válido: ");
            sc.next();
        }
        double valor = sc.nextDouble();
        sc.nextLine();
        return valor;
    }
}
