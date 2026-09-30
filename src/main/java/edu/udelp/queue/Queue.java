package src.main.java.edu.udelp.queue;

import src.main.java.edu.udelp.Nodo.Nodo;
import edu.udelp.Exception.UdelpException;

public class Queue {

    private Nodo front;
    private Nodo rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (isEmpty()) {
            front = nuevo;
            rear = nuevo;
        } else {

            rear.setSiguiente(nuevo);
            rear = nuevo;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new UdelpException("Cola vacia");
        }
        int valor = (int) front.getDato();
        front = front.getSiguiente();
        size--;
        return valor;
    }

    public int peek() {
        if (isEmpty()) {
            throw new UdelpException("Cola vacia");
        }
        return (int) front.getDato();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Nodo aux = front;
        while (aux != null) {
            s.append(aux.getDato()).append(" <- ");
            aux = aux.getSiguiente();
        }
        return s.toString();
    }
}
