package src.main.java.edu.udelp.Model;

import java.util.Scanner;

public class MainRPN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean seguir = true;

        System.out.println("===== CALCULADORA RPN =====");

        while (seguir) {

            System.out.println("1. Ingresa una operacion matematica(Suma.Resta,Multiplicacion y Division)115");
            System.out.println("2. Salir");
            System.out.print("Elige una opción: ");

            if (!sc.hasNextLine()) {
                break;
            }
            String opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1":
                    procesarExpresion(sc);
                    break;

                case "2":
                    System.out.println("Saliendo del programa");
                    seguir = false;
                    break;

                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
                    break;
            }
        }

        sc.close();
    }

    private static void procesarExpresion(Scanner sc) {
        System.out.print("Ingresa una expresión: ");
        if (!sc.hasNextLine()) {
            return;
        }
        String expresion = sc.nextLine();

        String postfija = ConversorRPN.infijaAPostfija(expresion);
        if (postfija == null) {
            System.out.println("No se pudo convertir la expresión.");
            return;
        }

        String resultado = ConversorRPN.evaluarPostfija(postfija);
        if (resultado == null) {
            System.out.println("No se pudo evaluar la expresión.");
            return;
        }

        System.out.println();
        System.out.println("Expresión infija:");
        System.out.println(expresion);
        System.out.println();
        System.out.println("Expresión postfija:");
        System.out.println(postfija);
        System.out.println();
        System.out.println("Resultado:");
        System.out.println(resultado);
    }
}

