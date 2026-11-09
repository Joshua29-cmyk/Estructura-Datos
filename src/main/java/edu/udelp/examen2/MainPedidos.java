package src.main.java.edu.udelp.examen2;

import java.util.List;
import java.util.Scanner;

public class MainPedidos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\n===== Gestor de pedidos =====");
            System.out.println("1. Registrar Pedido");
            System.out.println("2. Preparar Pedido");
            System.out.println("3. Entregar Pedido");
            System.out.println("4. Consultar Pedido");
            System.out.println("5. Mostrar historial de pedidos");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n== Registrar Pedido ===");
                    System.out.print("Ingrese el ID/Número del pedido: ");
                    int numeroPedido = Integer.parseInt(entrada.nextLine());

                    System.out.print("Ingrese el nombre del cliente: ");
                    String cliente = entrada.nextLine();

                    System.out.print("Ingrese la cantidad de productos: ");
                    int cantidadPedidos = Integer.parseInt(entrada.nextLine());

                    String estadoInicial = "Registrado";

                    // Crea y guarda el nuevo pedido
                    Pedidos nuevoPedido = new Pedidos(numeroPedido, cliente, cantidadPedidos, estadoInicial);
                    List<Pedidos> listaPedidos = null;
                    listaPedidos.add(nuevoPedido);
                    System.out.println("Pedido registrado exitosamente");
                    break;

                case 2:
                    System.out.println("\n=== Preparar Pedido ===");
                    System.out.print("Ingrese el ID del pedido a preparar: ");
                    int idPreparar = Integer.parseInt(entrada.nextLine());
                    Pedidos pedidoPreparar = buscarPedidoPorId(listaPedidos, idPreparar);

                    if (pedidoPreparar != null) {
                        pedidoPreparar.getestado("En preparación");
                        System.out.println("El estado del pedido #" + idPreparar + " ha cambiado a: En preparación");
                    } else {
                        System.out.println("Pedido no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("\n=== Entregar Pedido ===");
                    System.out.print("Ingrese el ID del pedido a entregar: ");
                    int idEntregar = Integer.parseInt(entrada.nextLine());
                    Pedidos pedidoEntregar = buscarPedidoPorId(listaPedidos, idEntregar);

                    if (pedidoEntregar != null) {
                        pedidoEntregar.getestado("Entregado");
                        System.out.println("El estado del pedido #" + idEntregar + " ha cambiado a: Entregado");
                    } else {
                        System.out.println("Pedido no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n=== Consultar Pedido ===");
                    System.out.print("Ingrese el ID del pedido a consultar: ");
                    int idConsultar = Integer.parseInt(entrada.nextLine());
                    Pedidos pedidoEncontrado = buscarPedidoPorId(listaPedidos, idConsultar);

                    if (pedidoEncontrado != null) {
                        System.out.println(pedidoEncontrado);
                    } else {
                        System.out.println("Pedido no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("\n=== Historial de Pedidos ===");
                    if (listaPedidos.isEmpty()) {
                        System.out.println("No hay pedidos registrados.");
                    } else {
                        for (Pedidos p : listaPedidos) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 6);

        entrada.close();
    }


    private static Pedidos buscarPedidoPorId(List<Pedidos> lista, int id) {
        for (Pedidos p : lista) {
            if (p.getNumeroPedido() == id) {
                return p;
            }
        }
        return null;
    }
}
