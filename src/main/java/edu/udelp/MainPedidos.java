package src.main.java.edu.udelp;

import src.main.java.edu.udelp.Model.Pedidos;
import src.main.java.edu.udelp.queue.ColaPedidos;

import java.util.Scanner;

public class MainPedidos {

    private static Scanner sc = new Scanner(System.in);
    private static ColaPedidos cola = new ColaPedidos();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Opción: ");
            System.out.println();

            switch (opcion) {
                case 1:
                    registrarPedido();
                    break;
                case 2:
                    prepararSiguiente();
                    break;
                case 3:
                    consultarSiguiente();
                    break;
                case 4:
                    cola.mostrar();
                    break;
                case 5:
                    buscarPedido();
                    break;
                case 6:
                    cola.tiempoTotalPendiente();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println();

        } while (opcion != 7);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("=====  MENU PARA PEDIDOS DE COCINA =====");
        System.out.println("Ingresa uel numero de opcion deseada");
        System.out.println("1. Registrar pedido");
        System.out.println("2. Preparar siguiente pedido");
        System.out.println("3. Consultar siguiente pedido");
        System.out.println("4. Mostrar pedidos pendientes");
        System.out.println("5. Buscar pedido por número");
        System.out.println("6. Mostrar tiempo total pendiente");
        System.out.println("7. Salir");

    }

    // ---------- Opción 1 ----------
    private static void registrarPedido() {
        int numero = leerEntero("Ingresa el id del pedido: ");

        if (cola.buscar(numero) != null) {
            System.out.println("Ya existe un pedido pendiente con ese id.");
            return;
        }

        System.out.print("Ingresa el nombre del cliente: ");
        String cliente = sc.nextLine().trim();

        System.out.print("Platillo: ");
        String platillo = sc.nextLine().trim();

        int cantidad = leerEnteroPositivo("Cantidad: ");
        int tiempo = leerEnteroPositivo("Tiempo estimado (minutos): ");

        cola.enqueue(new Pedidos(numero, cliente, platillo, cantidad, tiempo));

        System.out.println();
        System.out.println("Pedido " + numero + " registrado al final de la cola.");
    }

    // ---------- Opción 2 ----------
    private static void prepararSiguiente() {
        Pedidos p = cola.dequeue();

        if (p == null) {
            System.out.println("No hay pedidos por preparar.");
            return;
        }

        System.out.println("Preparando pedido " + p.getNumero());
        System.out.println("Cliente: " + p.getCliente());
        System.out.println("Platillo: " + p.getPlatillo());
    }

    // ---------- Opción 3 ----------
    private static void consultarSiguiente() {
        Pedidos p = cola.peek();

        if (p == null) {
            System.out.println("La cola está vacía.");
            return;
        }

        System.out.println("Siguiente pedido en el frente:");
        p.mostrarDetalle();
    }

    // ---------- Opción 5 ----------
    private static void buscarPedido() {
        int numero = leerEntero("id del pedido: ");
        Pedidos p = cola.buscar(numero);

        System.out.println();
        if (p == null) {
            System.out.println("El pedido " + numero + " no se encuentra.");
        } else {
            System.out.println("Pedido encontrado:");
            p.mostrarDetalle();
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número entero válido.");
            }
        }
    }

    private static int leerEnteroPositivo(String mensaje) {
        while (true) {
            int valor = leerEntero(mensaje);
            if (valor > 0) {
                return valor;
            }
            System.out.println("El valor debe ser mayor que cero.");
        }
    }
}