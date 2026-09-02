package edu.udelp.Stack;

import edu.udelp.Model.Pagina;
import edu.udelp.Nodo.NodoPagina;
import edu.udelp.Exception.UdelpException;

public class PaginaStack {

    private NodoPagina top;
    private int size;

    public PaginaStack() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Pagina peek() {
        if (isEmpty()) {
            throw new UdelpException("Pila vacía");
        }
        return top.getDato();
    }

    public void push(Pagina dato) {
        NodoPagina nuevo = new NodoPagina(dato);
        nuevo.setEnlace(top);
        top = nuevo;
        size++;
    }

    public Pagina pop() {
        if (isEmpty()) {
            throw new UdelpException("Pila vacía");
        }
        Pagina dato = top.getDato();
        top = top.getEnlace();
        size--;
        return dato;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        NodoPagina aux = top;
        while (aux != null) {
            s.append(aux.getDato()).append(" -> ");
            aux = aux.getEnlace();
        }
        s.append("null");
        return s.toString();
    }
}