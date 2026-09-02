package edu.udelp;

import edu.udelp.Model.Pagina;
import edu.udelp.Stack.PaginaStack;
import javax.swing.JOptionPane;

public class MainPagina {
    public static void main(String[] args) {
        // DECLARAR VARIABLES
        PaginaStack stack = new PaginaStack();
        PaginaStack stack2 = new PaginaStack();
        String[] opciones = {"Nueva Página", "Atrás", "Adelante", "Actual", "Menú de Páginas", "Salir"};
        boolean salir = false;

        while (!salir) {
            int option = JOptionPane.showOptionDialog(null, "Escoge una opción: ", "URL", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, null);

            switch (option) {
                case 0:
                    Pagina nueva = new Pagina();
                    String dato = JOptionPane.showInputDialog(null, "Escribe el nombre de la página: ");

                    nueva.setUrl(dato);
                    stack.push(nueva);
                    break;

                case 1:
                    if (!stack.isEmpty()) {
                        stack2.push(stack.peek());
                        stack.pop();
                    } else {
                        JOptionPane.showMessageDialog(null, "ACTUALMENTE NO TIENES PÁGINAS ABIERTAS...");
                    }
                    break;

                case 2:
                    if (!stack2.isEmpty()) {
                        stack.push(stack2.peek());
                        stack2.pop();
                    }
                    break;

                case 3:
                    if (!stack.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Página actual: " + stack.peek());
                    } else {
                        JOptionPane.showMessageDialog(null, "ACTUALMENTE NO ESTÁS EN NINGUNA PÁGINA...");
                    }
                    break;

                case 4:
                    if (!stack.isEmpty() && !stack2.isEmpty()) {
                        Pagina anterior = stack.peek();
                        Pagina siguiente = stack2.peek();
                        JOptionPane.showMessageDialog(null,
                                "Página anterior: " + anterior + "\nPágina siguiente: " + siguiente);
                    } else if (stack.isEmpty() && stack2.isEmpty()) {

                    } else {
                        JOptionPane.showMessageDialog(null, "NO HAS ABIERTO NINGUNA PÁGINA...");
                    }
                    break;

                case 5:
                    salir = true;
                    JOptionPane.showMessageDialog(null, "HAS SALIDO DEL MENÚ...");
                    break;
            }
        }
    }
}
