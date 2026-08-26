import java.util.Scanner;
import java.util.Stack;

public class Copilador {

   
    private static class Simbolo {
        char caracter;
        int posicion;

        Simbolo(char caracter, int posicion) {
            this.caracter = caracter;
            this.posicion = posicion;
        }
    }

   
    private static boolean coinciden(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '[' && cierre == ']') ||
               (apertura == '{' && cierre == '}');
    }

    
    public static String analizar(String expresion) {
        Stack<Simbolo> pila = new Stack<>();
        char anterior = '\0'; // último carácter relevante procesado (para validar comas)

        for (int i = 0; i < expresion.length(); i++) {
            char actual = expresion.charAt(i);

            switch (actual) {

                case '(':
                case '[':
                case '{':
                    pila.push(new Simbolo(actual, i));
                    anterior = actual;
                    break;

                case ')':
                case ']':
                case '}':
                    if (pila.isEmpty()) {
                        return error("Símbolo de cierre '" + actual + "' sin apertura correspondiente", i);
                    }
                    Simbolo tope = pila.pop();
                    if (!coinciden(tope.caracter, actual)) {
                        return error("Se esperaba el cierre de '" + tope.caracter +
                                     "' (abierto en la posición " + tope.posicion +
                                     ") pero se encontró '" + actual + "'", i);
                    }
                    if (anterior == ',') {
                        return error("Coma sobrante antes de '" + actual + "'", i - 1);
                    }
                    anterior = actual;
                    break;

                case ',':
                    if (anterior == '\0' || anterior == '(' || anterior == '[' || anterior == '{') {
                        return error("Coma inválida, no puede ir después de '" +
                                     (anterior == '\0' ? "el inicio de la expresión" : anterior) + "'", i);
                    }
                    if (anterior == ',') {
                        return error("Comas consecutivas no permitidas", i);
                    }
                    anterior = actual;
                    break;

                default:
                    // Letras, números, espacios u otros símbolos se ignoran
                    if (!Character.isWhitespace(actual)) {
                        anterior = actual;
                    }
                    break;
            }
        }

        if (anterior == ',') {
            return error("La expresión no puede terminar con una coma", expresion.length() - 1);
        }

        if (!pila.isEmpty()) {
            Simbolo faltante = pila.pop();
            return error("Falta cerrar el símbolo '" + faltante.caracter + "'", faltante.posicion);
        }

        return "✔ Sintaxis VÁLIDA: los paréntesis, corchetes, llaves y comas están correctamente balanceados.";
    }

    private static String error(String mensaje, int posicion) {
        return "✘ Sintaxis INVÁLIDA -> " + mensaje + " (posición " + posicion + ")";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== COPILADOR: Analizador de sintaxis con pilas ===");
        System.out.println("Escribe una expresión para analizar (o 'salir' para terminar):\n");

        // Ejemplos de prueba automáticos
        String[] pruebas = {
            "func(a, b, c)",
            "arreglo[1, 2, 3]",
            "objeto{clave: valor, otra: (1, 2)}",
            "func(a, ,b)",
            "func(a, b,)",
            "func(a, b))",
            "func((a, b)",
            "func(,a)",
        };

        System.out.println("--- Pruebas automáticas ---");
        for (String prueba : pruebas) {
            System.out.println("Entrada: " + prueba);
            System.out.println(analizar(prueba));
            System.out.println();
        }

        System.out.println("--- Modo interactivo ---");
        while (true) {
            System.out.print("Expresión: ");
            String entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("salir")) {
                break;
            }
            System.out.println(analizar(entrada));
            System.out.println();
        }

        scanner.close();
        System.out.println("Fin del análisis.");
    }
}