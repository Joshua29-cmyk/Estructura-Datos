package edu.udelp.Stack;

import edu.udelp.Model.Paqueteria;
import edu.udelp.Nodo.NodoPaqueteria;

public class StackPaqueteria {

    private NodoPaqueteria tope;
    private int cantidad;

    // Se corrigió el nombre y se eliminó el void
    public StackPaqueteria() {
        this.tope = null;
        this.cantidad = 0;
    }

    public void push(Paqueteria paquete) {
        NodoPaqueteria nuevo = new NodoPaqueteria(paquete);
        nuevo.siguiente = tope;
        tope = nuevo;
        cantidad++;
    }

    public Paqueteria pop() {
        if (isEmpty()) {
            System.out.println("No es posible retirar: el almacén está vacío.");
            return null;
        }
        // Se cambió tope.NodoPaquete por tope.paquete
        Paqueteria paqueteRetirado = tope.paquete;
        tope = tope.siguiente;
        cantidad--;
        return paqueteRetirado;
    }

    public Paqueteria peek() {
        if (isEmpty()) {
            System.out.println("No hay paquetes en el almacén.");
            return null;
        }
        // Se cambió tope.NodoPaquete por tope.paquete
        return tope.paquete;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("El almacén no tiene paquetes.");
            return;
        }
        System.out.println("----- Paquetes en el almacén -----");
        NodoPaqueteria actual = tope;
        int posicion = 1;
        while (actual != null) {
            String etiqueta = (posicion == 1) ? " (TOPE)" : "";
            System.out.println("\n[" + posicion + "]" + etiqueta);
            // Se cambió actual.NodoPaquete por actual.paquete
            System.out.println(actual.paquete);
            actual = actual.siguiente;
            posicion++;
        }
        System.out.println("\n--------------------------------------------------");
    }

    public Paqueteria buscar(int id) {
        NodoPaqueteria actual = tope;
        while (actual != null) {
            if (actual.paquete != null && actual.paquete.getId() == id) {
                return actual.paquete;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public int getCantidad() {
        return cantidad;
    }
}