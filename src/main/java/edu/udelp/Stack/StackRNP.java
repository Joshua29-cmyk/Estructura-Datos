package src.main.java.edu.udelp.Stack;

public class StackRNP {

    private class Nodo {
        private Object dato;
        private Nodo siguiente;

        private Nodo(Object dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo tope;
    private int tamaño;

    public StackRNP() {
        this.tope = null;
        this.tamaño = 0;
    }

    public void empujar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = tope;
        tope = nuevo;
        tamaño = tamaño + 1;
    }

    public Object sacar() {
        if (estaVacia()) {
            return null;
        }
        Object dato = tope.dato;
        tope = tope.siguiente;
        tamaño = tamaño - 1;
        return dato;
    }

    public Object peek() {
        if (estaVacia()) {
            return null;
        }
        return tope.dato;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamaño() {
        return tamaño;
    }
}
