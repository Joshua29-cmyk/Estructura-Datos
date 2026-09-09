package src.main.java.edu.udelp.Model;

import src.main.java.edu.udelp.Stack.StackRNP;

public class ConversorRPN {

    public static int precedencia(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/') {
            return 2;
        }
        return -1;
    }

    public static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static String infijaAPostfija(String infija) {
        StackRNP pilaOperadores = new StackRNP();
        String postfija = "";
        int n = infija.length();
        boolean esperandoOperando = true;

        for (int i = 0; i < n; i++) {
            char c = infija.charAt(i);

            if (c == ' ') {
                continue;
            }

            if (c >= '0' && c <= '9') {
                String numero = "";
                while (i < n && infija.charAt(i) >= '0' && infija.charAt(i) <= '9') {
                    numero = numero + infija.charAt(i);
                    i++;
                }
                i--;
                postfija = postfija + numero + " ";
                esperandoOperando = false;
            }
            else if (c == '(') {
                pilaOperadores.empujar(c);
                esperandoOperando = true;
            }
            else if (c == ')') {
                if (esperandoOperando) {
                    System.out.println("Error: La expresión esta incompleta dentro del paréntesis.");
                    return null;
                }
                boolean encontradoApertura = false;
                while (!pilaOperadores.estaVacia()) {
                    char op = (Character) pilaOperadores.sacar();
                    if (op == '(') {
                        encontradoApertura = true;
                        break;
                    }
                    postfija = postfija + op + " ";
                }
                if (!encontradoApertura) {
                    System.out.println("Error: Los parentesis estan mal colocados.");
                    return null;
                }
            }
            else if (esOperador(c)) {
                if (esperandoOperando) {
                    System.out.println("Error: Operador fuera de lugar.");
                    return null;
                }
                while (!pilaOperadores.estaVacia()) {
                    char opTope = (Character) pilaOperadores.peek();
                    if (precedencia(c) <= precedencia(opTope)) {
                        postfija = postfija + pilaOperadores.sacar() + " ";
                    } else {
                        break;
                    }
                }
                pilaOperadores.empujar(c);
                esperandoOperando = true;
            }
            else {
                System.out.println("Error: Caracter  invalido " + c);
                return null;
            }
        }

        if (esperandoOperando) {
            System.out.println("Error: La expresion final esta incompleta.");
            return null;
        }

        while (!pilaOperadores.estaVacia()) {
            char op = (Character) pilaOperadores.sacar();
            if (op == '(' || op == ')') {
                System.out.println("Error: Los parentesis estan mal colocados.");
                return null;
            }
            postfija = postfija + op + " ";
        }

        return postfija;
    }

    public static String evaluarPostfija(String postfija) {
        StackRNP pilaNumeros = new StackRNP();
        int n = postfija.length();

        for (int i = 0; i < n; i++) {
            char c = postfija.charAt(i);

            if (c == ' ') {
                continue;
            }

            if (c >= '0' && c <= '9') {
                String numeroStr = "";
                while (i < n && postfija.charAt(i) >= '0' && postfija.charAt(i) <= '9') {
                    numeroStr = numeroStr + postfija.charAt(i);
                    i++;
                }
                i--;
                double numero = Double.parseDouble(numeroStr);
                pilaNumeros.empujar(numero);
            }
            else if (esOperador(c)) {
                if (pilaNumeros.getTamaño() < 2) {
                    System.out.println("Error: No hay suficientes numeros para el operador " + c);
                    return null;
                }
                double b = (Double) pilaNumeros.sacar();
                double a = (Double) pilaNumeros.sacar();
                double resultado = 0;

                if (c == '+') {
                    resultado = a + b;
                } else if (c == '-') {
                    resultado = a - b;
                } else if (c == '*') {
                    resultado = a * b;
                } else if (c == '/') {
                    if (b == 0) {
                        System.out.println("Error: Division entre cero.");
                        return null;
                    }
                    resultado = a / b;
                }

                pilaNumeros.empujar(resultado);
            }
        }

        if (pilaNumeros.getTamaño() != 1) {
            System.out.println("Error: Expresion mal ingresada.");
            return null;
        }

        double res = (Double) pilaNumeros.sacar();

        if (res == (long) res) {
            return "" + (long) res;
        } else {
            return "" + res;
        }
    }
}