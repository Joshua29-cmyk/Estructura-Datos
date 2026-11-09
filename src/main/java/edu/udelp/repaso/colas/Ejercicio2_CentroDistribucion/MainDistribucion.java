package src.main.java.edu.udelp.repaso.colas.Ejercicio2_CentroDistribucion;

import java.util.Scanner;
import src.main.java.edu.udelp.list.LinkedList;

public class MainDistribucion {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        LinkedList<Paquete> estacion1 = new LinkedList<>();
        LinkedList<Paquete> estacion2 = new LinkedList<>();
        LinkedList<Paquete> estacion3 = new LinkedList<>();

        int opcion;

        do {
            System.out.println("\n--- CENTRO DE DISTRIBUCION ---");
            System.out.println("1. Registrar paquete");
            System.out.println("2. Procesar estaciones");
            System.out.println("3. Transferir paquete");
            System.out.println("4. Mostrar estaciones");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("ID del paquete: ");
                    String id = entrada.nextLine();

                    System.out.print("Destino: ");
                    String destino = entrada.nextLine();

                    System.out.print("Minutos de procesamiento: ");
                    int minutos = entrada.nextInt();
                    entrada.nextLine();

                    Paquete paquete = new Paquete(id, destino, minutos);

                    int carga1 = calcularCarga(estacion1);
                    int carga2 = calcularCarga(estacion2);
                    int carga3 = calcularCarga(estacion3);

                    if (carga1 <= carga2 && carga1 <= carga3) {
                        estacion1.add(estacion1.size(), paquete);
                        System.out.println("Asignado a estacion 1.");
                    } else if (carga2 <= carga3) {
                        estacion2.add(estacion2.size(), paquete);
                        System.out.println("Asignado a estacion 2.");
                    } else {
                        estacion3.add(estacion3.size(), paquete);
                        System.out.println("Asignado a estacion 3.");
                    }
                    break;

                case 2:
                    procesar(estacion1, 1);
                    procesar(estacion2, 2);
                    procesar(estacion3, 3);
                    break;

                case 3:
                    System.out.print("Estacion de origen (1-3): ");
                    int origen = entrada.nextInt();

                    System.out.print("Estacion de destino (1-3): ");
                    int destinoEstacion = entrada.nextInt();

                    if (origen < 1 || origen > 3 ||
                            destinoEstacion < 1 || destinoEstacion > 3 ||
                            origen == destinoEstacion) {
                        System.out.println("Estaciones no validas.");
                        break;
                    }

                    LinkedList<Paquete> colaOrigen =
                            obtenerEstacion(origen, estacion1, estacion2, estacion3);

                    LinkedList<Paquete> colaDestino =
                            obtenerEstacion(destinoEstacion, estacion1, estacion2, estacion3);

                    if (colaOrigen.isEmpty()) {
                        System.out.println("La estacion de origen esta vacia.");
                    } else {
                        Paquete transferido = colaOrigen.remove(0);
                        colaDestino.add(colaDestino.size(), transferido);
                        System.out.println("Paquete transferido: " + transferido);
                    }
                    break;

                case 4:
                    mostrar(estacion1, 1);
                    mostrar(estacion2, 2);
                    mostrar(estacion3, 3);
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

    // Calculo el tiempo pendiente de una estación.
    public static int calcularCarga(LinkedList<Paquete> cola) {

        int total = 0;

        for (int i = 0; i < cola.size(); i++) {
            total += cola.get(i).getMinutos();
        }

        return total;
    }

    // Proceso un paquete completo de la estación.
    public static void procesar(LinkedList<Paquete> cola, int numero) {

        if (cola.isEmpty()) {
            System.out.println("Estacion " + numero + " sin paquetes.");
        } else {
            System.out.println("Estacion " + numero +
                    " proceso: " + cola.remove(0));
        }
    }

    // Obtengo la estación seleccionada.
    public static LinkedList<Paquete> obtenerEstacion(
            int numero,
            LinkedList<Paquete> e1,
            LinkedList<Paquete> e2,
            LinkedList<Paquete> e3) {

        if (numero == 1) {
            return e1;
        } else if (numero == 2) {
            return e2;
        }

        return e3;
    }

    // Muestro los paquetes y la carga de trabajo.
    public static void mostrar(LinkedList<Paquete> cola, int numero) {

        System.out.println("\nEstacion " + numero);

        for (int i = 0; i < cola.size(); i++) {
            System.out.println(cola.get(i));
        }

        System.out.println("Carga pendiente: " + calcularCarga(cola) + " minutos");
    }
}