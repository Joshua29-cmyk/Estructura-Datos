
public class Parentesis {

    private Object stack;

    public boolean evaluar (String ecuacion, char c){

        boolean resultado = false;
        ArrayStack pila = new ArrayStack(ecuacion.length());

        for (int i = 0; i < ecuacion.length(); i++){
            char caracter = ecuacion.charAt(i);

            if (c == '('){
               stack.push(c);
            } else if (c == ')'){
                stack.pop();
            }
        }

        return resultado;
    }
}