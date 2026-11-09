package src.main.java.edu.udelp.repaso.listasenlazadas.Ejercicio6_ReorganizacionLista;

import java.util.Scanner;
import src.main.java.edu.udelp.list.LinkedList;

public class MainReorganizacion {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        LinkedList<Integer> lista = new LinkedList<>();

        int opcion;

        do {
            System.out.println("\n--- REORGANIZACION DE UNA LISTA ---");
            System.out.println("1. Agregar numero");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Colocar pares antes de impares");
            System.out.println("4. Eliminar duplicados");
            System.out.println("5. Invertir lista");
            System.out.println("6. Encontrar elemento central");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingresa un numero: ");
                    int numero = entrada.nextInt();

                    lista.add(lista.size(), numero);

                    System.out.println("Numero agregado.");
                    break;

                case 2:
                    if (lista.isEmpty()) {
                        System.out.println("La lista esta vacia.");
                    } else {
                        System.out.println("Contenido de la lista:");

                        for (int i = 0; i < lista.size(); i++) {
                            System.out.print(lista.get(i) + " ");
                        }

                        System.out.println();
                    }
                    break;

                case 3:
                    // Coloco los numeros pares al principio sin cambiar su orden.
                    int posicionPar = 0;

                    for (int i = 0; i < lista.size(); i++) {

                        if (lista.get(i) % 2 == 0) {

                            int par = lista.remove(i);

                            lista.add(posicionPar, par);

                            posicionPar++;
                        }
                    }

                    System.out.println("Pares colocados antes de impares.");
                    break;

                case 4:
                    // Elimino los valores repetidos y conservo la primera aparición.
                    for (int i = 0; i < lista.size(); i++) {

                        for (int j = i + 1; j < lista.size(); j++) {

                            if (lista.get(i).equals(lista.get(j))) {
                                lista.remove(j);
                                j--;
                            }
                        }
                    }

                    System.out.println("Duplicados eliminados.");
                    break;

                case 5:
                    // Intercambio los extremos para invertir la lista.
                    for (int i = 0; i < lista.size() / 2; i++) {

                        int auxiliar = lista.get(i);
                        int posicionFinal = lista.size() - 1 - i;

                        lista.set(i, lista.get(posicionFinal));
                        lista.set(posicionFinal, auxiliar);
                    }

                    System.out.println("Lista invertida.");
                    break;

                case 6:
                    if (lista.isEmpty()) {
                        System.out.println("La lista esta vacia.");
                    } else {
                        // Avanzo una posición con lento y dos con rápido.
                        int lento = 0;
                        int rapido = 0;

                        while (rapido + 1 < lista.size()) {
                            lento++;
                            rapido += 2;
                        }

                        System.out.println("Elemento central: " + lista.get(lento));
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
}