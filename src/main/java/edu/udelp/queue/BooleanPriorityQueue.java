package src.main.java.edu.udelp.queue;

import src.main.java.edu.udelp.Nodo.PriorityNodo;

public class BooleanPriorityQueue<T> {

    // ATRIBUTOS
    private PriorityNodo<T> front;
    private PriorityNodo<T> rear;
    private int size;

    // CONSTRUCTOR
    public BooleanPriorityQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // isEmpty() --> verifica si la cola está vacía
    public boolean isEmpty() {
        return front == null;
    }

    // size() --> devuelve el tamaño de la cola
    public int size() {
        return size;
    }

    // enqueue() --> agregar elemento considerando prioridad booleana
    public void enqueue(T valor, boolean priority) {
        PriorityNodo<T> nuevo = new PriorityNodo<>(valor, priority);

        if (isEmpty()) {
            front = nuevo;
            rear = nuevo;
        } else if (priority && !front.isPriority()) {

            nuevo.setEnlace(front);
            front = nuevo;
        } else {

            PriorityNodo<T> aux = front;



            while (aux.getEnlace() != null && !(priority && !aux.getEnlace().isPriority())) {
                aux = aux.getEnlace();
            }

            nuevo.setEnlace(aux.getEnlace());
            aux.setEnlace(nuevo);


            if (nuevo.getEnlace() == null) {
                rear = nuevo;
            }
        }
        size++;
    }

    // dequeue() --> eliminar y retornar el elemento del frente
    public T dequeue() {
        if (isEmpty()) {
            System.out.println(" LA COLA SE ENCUENTRA VACÍA ");
            return null;
        }

        T valor = front.getDato();
        front = front.getEnlace();
        size--;

        if (front == null) {
            rear = null;
        }

        return valor;
    }

    // peek() --> solicitar el elemento del frente sin eliminarlo
    public T peek() {
        if (isEmpty()) {
            System.out.println("[!] LA COLA SE ENCUENTRA VACÍA [!]");
            return null;
        }

        return front.getDato();
    }


    @Override
    public String toString() {
        if (isEmpty()) {
            return "Cola vacía";
        }

        StringBuilder s = new StringBuilder();
        PriorityNodo<T> aux = front;

        while (aux != null) {
            s.append(aux.getDato())
                    .append(" (")
                    .append(aux.isPriority() ? "VIP" : "Normal")
                    .append(")");

            if (aux.getEnlace() != null) {
                s.append(" <- ");
            }
            aux = aux.getEnlace();
        }

        return s.toString();
    }
}