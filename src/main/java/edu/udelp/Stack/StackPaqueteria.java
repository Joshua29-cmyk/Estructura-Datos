package src.main.java.edu.udelp.Stack;

import src.main.java.edu.udelp.Model.Paqueteria;
import src.main.java.edu.udelp.Nodo.NodoPaqueteria;

public class StackPaqueteria {

    private NodoPaqueteria tope;
    private int cantidad;

    public StackPaqueteria() {
        this.tope = null;
        this.cantidad = 0;
    }

    public void push(Paqueteria paquete) {
        NodoPaqueteria nuevo = new NodoPaqueteria(paquete);
        nuevo.setSiguiente(tope);
        tope = nuevo;
        cantidad++;
    }

    public Paqueteria pop() {
        if (isEmpty()) {
            System.out.println("No es posible retirar: el almacén está vacío.");
            return null;
        }
        Paqueteria paqueteRetirado = tope.getPaquete();
        tope = tope.getSiguiente();
        cantidad--;
        return paqueteRetirado;
    }

    public Paqueteria peek() {
        if (isEmpty()) {
            System.out.println("No hay paquetes en el almacén.");
            return null;
        }
        return tope.getPaquete();
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
            System.out.println(actual.getPaquete());
            actual = actual.getSiguiente();
            posicion++;
        }
        System.out.println("\n--------------------------------------------------");
    }

    public Paqueteria buscar(int id) {
        NodoPaqueteria actual = tope;
        while (actual != null) {
            if (actual.getPaquete() != null && actual.getPaquete().getId() == id) {
                return actual.getPaquete();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public int getCantidad() {
        return cantidad;
    }
}