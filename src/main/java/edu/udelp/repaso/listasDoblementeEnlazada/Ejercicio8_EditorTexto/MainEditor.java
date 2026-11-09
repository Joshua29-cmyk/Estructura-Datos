package src.main.java.edu.udelp.repaso.listasDoblementeEnlazada.Ejercicio8_EditorTexto;
import src.main.java.edu.udelp.repaso.listasDoblementeEnlazada.Ejercicio8_EditorTexto.ListaEditor;
import java.util.Scanner;

public class MainEditor {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        ListaEditor<String> versiones = new ListaEditor<>();

        // Inicio el editor con una primera versión.
        versiones.add(0, "Hola");

        int actual = 0;
        int opcion;

        do {
            System.out.println("\n === EDITOR DE TEXTO ===");
            System.out.println("1. Escribir nueva version");
            System.out.println("2. Deshacer");
            System.out.println("3. Rehacer");
            System.out.println("4. Mostrar version actual");
            System.out.println("5. Mostrar historial");
            System.out.println("6. Mostrar pasos disponibles");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("Escribe el nuevo texto:");
                    String texto = entrada.nextLine();

                    // Elimino las versiones posteriores a la actual.
                    while (versiones.size() > actual + 1) {
                        versiones.remove(versiones.size() - 1);
                    }

                    // Agrego la nueva version al final.
                    versiones.add(versiones.size(), texto);

                    actual++;

                    // Mantengo un maximo de diez versiones.
                    if (versiones.size() > 10) {
                        versiones.remove(0);
                        actual--;
                    }

                    System.out.println("Nueva version guardada.");
                    break;

                case 2:
                    if (actual > 0) {
                        actual--;
                        System.out.println("Se deshizo el cambio.");
                    } else {
                        System.out.println("No hay mas versiones para deshacer.");
                    }
                    break;

                case 3:
                    if (actual + 1 < versiones.size()) {
                        actual++;
                        System.out.println("Se rehizo el cambio.");
                    } else {
                        System.out.println("No hay versiones para rehacer.");
                    }
                    break;

                case 4:
                    System.out.println("Version actual: "
                            + versiones.get(actual));
                    break;

                case 5:
                    System.out.println("\n--- HISTORIAL DE VERSIONES ---");

                    for (int i = 0; i < versiones.size(); i++) {

                        if (i == actual) {
                            System.out.println("-> Version " + (i + 1)
                                    + ": " + versiones.get(i) + " (Actual)");
                        } else {
                            System.out.println("Version " + (i + 1)
                                    + ": " + versiones.get(i));
                        }
                    }
                    break;

                case 6:
                    int deshacer = actual;
                    int rehacer = versiones.size() - actual - 1;

                    System.out.println("Pasos para deshacer: " + deshacer);
                    System.out.println("Pasos para rehacer: " + rehacer);
                    break;

                case 0:
                    System.out.println("Editor finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        entrada.close();
    }
}