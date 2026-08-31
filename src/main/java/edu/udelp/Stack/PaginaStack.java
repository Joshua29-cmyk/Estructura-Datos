package edu.udelp.Stack;
import edu.udelp.Model.Pagina;
import edu.udelp.Nodo.Nodo;
import edu.udelp.Nodo.NodoPagina;
import edu.udelp.Exception.UdelpException;

public class PaginaStack{

    
    private NodoPagina top;
    private int size;

    public PaginaStack () {
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
            throw new UdelpException("Pila vacia");
        }
        return top.getDato();
    }

    public void push(Pagina dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setEnlace(top);
        top = nuevo;
        size++;
    }

    public Pagina pop() {
        if (isEmpty()) {
            throw new UdelpException("Pila vacia");
        }
        Pagina dato = top.getDato();
        top = top.getEnlace();
        size--;
        return dato;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Nodo aux = top;
        while (aux != null) {
            s.append(aux.getDato()).append(" -> ");
            aux = aux.getEnlace();
        }
        s.append("null");
        return s.toString();
    }
}