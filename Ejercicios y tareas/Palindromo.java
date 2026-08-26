import java.util.Scanner;
import java.util.Stack;

public class Palindromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa una pa: ");
        String palabra = scanner.nextLine().toLowerCase();

        Stack<Character> pila = new Stack<>();

        //  Guardar cada letra en la pila
        for (int i = 0; i < palabra.length(); i++) {
            pila.push(palabra.charAt(i));
        }

        // Hacer la comparación de letra por letra al momento de desapilar
        boolean esPalindromo = true;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) != pila.pop()) {
                esPalindromo = false;
                break;
            }
        }
        // Toda palabra que sera ingresada tendra que ser sin espacios 
        // Imprimir el resultado dependiendo de la palabra ingresada
        if (esPalindromo) {
            System.out.println("La palabra ingresada si es un palíndromo.");
        } else {
            System.out.println("La palabra ingresada no es un palíndromo.");
        }

        
    }
}
