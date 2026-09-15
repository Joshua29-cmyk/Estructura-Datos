package src.main.java.edu.udelp.queue;

import src.main.java.edu.udelp.Model.Pedidos;
import src.main.java.edu.udelp.Nodo.Nodo;

public class ColaPedidos {

    private Nodo frente;
    private Nodo fin;
    private int tamaño;

    public ColaPedidos() {
        this.frente = null;
        this.fin = null;
        this.tamaño = 0;
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public int getTamanio() {
        return tamaño;
    }

    public void enqueue(Pedidos pedido) {
        Nodo nuevo = new Nodo(pedido);

        if (isEmpty()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }

        tamaño++;
    }

    public Pedidos dequeue() {
        if (isEmpty()) {
            return null;
        }

        Pedidos atendido = frente.getPedido();
        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        tamaño--;
        return atendido;
    }

    public Pedidos peek() {
        if (isEmpty()) {
            return null;
        }
        return frente.getPedido();
    }

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
            return;
        }

        System.out.println("FRENTE");
        Nodo actual = frente;
        while (actual != null) {
            System.out.println("  " + actual.getPedido());
            actual = actual.getSiguiente();
        }
        System.out.println("FINAL");
    }

    public Pedidos buscar(int numero) {
        Nodo actual = frente;
        while (actual != null) {
            if (actual.getPedido().getNumero() == numero) {
                return actual.getPedido();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public int tiempoTotalPendiente() {
        if (isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
            return 0;
        }

        int total = 0;
        Nodo actual = frente;
        while (actual != null) {
            Pedidos p = actual.getPedido();
            System.out.println("Pedido " + p.getNumero() + ": " + p.getTiempoEstimado() + " min");
            total += p.getTiempoEstimado();
            actual = actual.getSiguiente();
        }

        System.out.println();
        System.out.println("Tiempo total pendiente: " + total + " minutos");
        return total;
    }

    public Pedidos pedidoMayorTiempo() {
        if (isEmpty()) {
            return null;
        }

        Pedidos mayor = frente.getPedido();
        Nodo actual = frente.getSiguiente();

        while (actual != null) {
            if (actual.getPedido().getTiempoEstimado() > mayor.getTiempoEstimado()) {
                mayor = actual.getPedido();
            }
            actual = actual.getSiguiente();
        }

        return mayor;
    }
}
