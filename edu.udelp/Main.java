
public class Main {

    public static void main(String[] args) {
        String ecuacion = " ";
        Parentesis par = new Parentesis();
        boolean resultado = par.evaluar(ecuacion, '(');

        if(resultado){
            System.out.println("La ecuacion es correcta");
        } else {
            System.out.println("La ecuacion es incorrecta");
        }
    
}

    private static class Parentesis {

        public Parentesis() {
        }

        private boolean evaluar(String ecuacion, char c) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}