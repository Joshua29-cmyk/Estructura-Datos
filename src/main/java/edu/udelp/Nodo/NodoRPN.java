package edu.udelp.Nodo;

public class NodoRPN {

    private Object dato;
    private NodoRPN siguiente;

    public NodoRPN(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoRPN getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoRPN siguiente) {
        this.siguiente = siguiente;
    }
}
