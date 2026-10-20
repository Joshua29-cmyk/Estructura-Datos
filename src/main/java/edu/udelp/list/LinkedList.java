package src.main.java.edu.udelp.list;

import edu.udelp.Exception.UdelpException;
import src.main.java.edu.udelp.Nodo.Nodo;

import java.lang.module.FindException;

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


    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new UdelpException("Index out of bounds");
        }

        T obj;

        // Eliminar el primer nodo
        if (index == 0) {
            obj = pointer.getDato();
            pointer = pointer.getEnlace();
        } else {
            Nodo<T> anterior = pointer;

            // Buscar el nodo anterior al que queremos eliminar
            for (int i = 0; i < index - 1; i++) {
                anterior = anterior.getEnlace();
            }

            // Obtener el nodo que se va a eliminar
            Nodo<T> actual = anterior.getEnlace();

            obj = actual.getDato();

            // Saltar el nodo eliminado
            anterior.setEnlace(actual.getEnlace());
        }

        size--;
        return obj;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new UdelpException("Index out of bounds");
        }

        Nodo<T> actual = pointer;

        for (int i = 0; i < index; i++) {
            actual = actual.getEnlace();
        }

        return actual.getDato();
    }


}
