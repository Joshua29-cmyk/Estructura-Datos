package src.main.java.edu.udelp.Model;

import java.util.Scanner;

public class Hospital {

    private static Scanner sc = new Scanner(System.in);


    private static int pacientesUrgentes = 0;
    private static int pacientesNormales = 0;
    private static int totalProcesados = 0;

    public static void main(String[] args) {
        int opcion = 0;

        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Por favor ingresa un número válido.");
                sc.nextLine();
                continue;
            }

            System.out.println();

            switch (opcion) {
                case 1:
                    registrarPaciente();
                    break;
                case 2:
                    atender();
                    break;
                case 3:
                    mostrarPendiente();
                    break;
                case 4:
                    mostrarEstadisticas();
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }

            System.out.println();

        } while (opcion != 4);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("======= SISTEMA DE ATENCIÓN HOSPITALARIA =======");
        System.out.println("1. Registrar paciente");
        System.out.println("2. Atender paciente");
        System.out.println("3. Mostrar pacientes pendientes");
        System.out.println("4. Mostrar estadísticas y salir");
    }

    private static void registrarPaciente() {
        System.out.println("--- Ingresando datos del paciente ---");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();

        System.out.print("Edad: ");
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa la edad del paciente : ");
            sc.next();
        }
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.println("Tipo de atención (1. Urgente | 2. Normal): ");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Motivo de la consulta: ");
        String motivo = sc.nextLine().trim();

        if (tipo == 1) {
            pacientesUrgentes++;
        } else {
            pacientesNormales++;
        }
        totalProcesados++;

        System.out.println("Paciente \"" + nombre + "\" registrado con éxito.");
    }

    public static void atender() {
        if (totalProcesados == 0) {
            System.out.println("No hay pacientes registrados en el sistema para atender.");
        } else {
            System.out.println("Atendiendo al siguiente paciente ");
        }
    }

    public static void mostrarPendiente() {
        System.out.println("Mostrando consultas pendientes...");
        System.out.println("Pacientes urgentes en espera: " + pacientesUrgentes);
        System.out.println("Pacientes normales en espera: " + pacientesNormales);
    }

    private static void mostrarEstadisticas() {
        System.out.println("=================================");
        System.out.println("   RESULTADO FINAL         ");
        System.out.println("=================================");
        System.out.println("Pacientes Urgentes (U): " + pacientesUrgentes);
        System.out.println("Pacientes Normales (N): " + pacientesNormales);
        System.out.println("Total procesados: " + totalProcesados);
        System.out.println("Saliendo del sistema...");
    }
}
