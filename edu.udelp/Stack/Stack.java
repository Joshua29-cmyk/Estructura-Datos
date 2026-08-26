package edu.udelp.Stack;
import edu.udelp.exception.UdelpException;

public class Stack{

    private Nodo top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (isEmpty()) {
            throw new UdelpException("Pila vacia");
        }
        return top.getDato();
    }

    
}


