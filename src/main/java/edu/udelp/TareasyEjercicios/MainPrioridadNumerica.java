
package src.main.java.edu.udelp.TareasyEjercicios;

import java.util.Scanner;

public class MainPrioridadNumerica {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        ColaPrioridad cola = new ColaPrioridad();

        int opcion;

        do {

            System.out.println("\n==== PRIORIDAD NUMERICA ====");
            System.out.println("1. Agregar numero");
            System.out.println("2. Atender numero");
            System.out.println("3. Mostrar cola");
            System.out.println("4. Mostrar cantidad");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Ingresa el numero: ");
                    int numero = entrada.nextInt();

                    System.out.println("1. Alta");
                    System.out.println("2. Media");
                    System.out.println("3. Baja");
                    System.out.print("Ingresa la prioridad: ");

                    int prioridad = entrada.nextInt();

                    if (prioridad >= 1 && prioridad <= 3) {

                        cola.add(numero, prioridad);

                        System.out.println("Numero agregado.");

                    } else {

                        System.out.println("Prioridad incorrecta.");
                    }

                    break;

                case 2:

                    if (!cola.isEmpty()) {

                        int atendido = cola.remove();

                        System.out.println("Numero atendido: " + atendido);

                    } else {

                        System.out.println("La cola esta vacia.");
                    }

                    break;

                case 3:

                    cola.mostrar();

                    break;

                case 4:

                    System.out.println("Numeros pendientes: " + cola.size());

                    break;

                case 5:

                    System.out.println("Fin del programa.");

                    break;

                default:

                    System.out.println("Opcion incorrecta.");

                    break;
            }

        } while (opcion != 5);

        entrada.close();
    }
}

