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
    }

    private static void imprime(Stack stack) {
        System.out.println(stack);
    }
}
