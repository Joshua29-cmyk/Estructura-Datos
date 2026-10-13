package src.main.java.edu.udelp.list;

import edu.udelp.Exception.UdelpException;
import src.main.java.edu.udelp.Nodo.Nodo;

public class LinkedList<T> {

    private Nodo<T> pointer;
    private int size;

    public LinkedList() {
        this.pointer = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return pointer == null;
    }

    public int size() {
        return size;
    }

    // Agrega un elemento al inicio de la lista
    public void add(T element) {
        Nodo<T> nuevo = new Nodo<>(element);
        if (pointer != null) {
            nuevo.setEnlace(pointer);
        }
        pointer = nuevo;
        size++;
    }

    // Agrega un elemento en un índice específico (0 <= index <= size)
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new UdelpException("Index out of bounds");
        }

        Nodo<T> nuevo = new Nodo<>(element);

        // Caso 1: Insertar al inicio
        if (index == 0) {
            nuevo.setEnlace(pointer);
            pointer = nuevo;
        }
        // Caso 2: Insertar en medio o al final
        else {
            Nodo<T> actual = pointer;
            // Avanzamos hasta el nodo anterior a la posición deseada
            for (int i = 0; i < index - 1; i++) {
                actual = actual.getEnlace();
            }

            actual.setEnlace(nuevo);
        }

        size++;
    }
}
