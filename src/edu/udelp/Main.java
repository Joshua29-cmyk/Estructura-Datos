package src.edu.udelp;

import src.edu.udelp.nodo.Nodo;
import src.edu.udelp.Stack.Stack;
import src.edu.udelp.Exception.UdelpException;
import java.util.Stack;

    public class Main {

        public static void main(String[] args) {
            Stack stack = new Stack();
            imprime(stack);

            stack.push(5);
            imprime(stack);

            stack.push(6);
            imprime(stack);

            stack.push(7);
            imprime(stack);

            stack.push(8);
            imprime(stack);

            stack.pop();
            imprime(stack);

            stack.pop();
            imprime(stack);
        }

        public static void imprime(Stack stack) {
            System.out.println("Stack contents");
            System.out.println(stack);
            try {
                System.out.println("peek:" + stack.peek());
            } catch (UdelpException e) {
                System.out.println("size:" + stack.size());
            }
        }
    }