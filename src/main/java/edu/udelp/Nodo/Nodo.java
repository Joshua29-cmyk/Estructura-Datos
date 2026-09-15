package src.main.java.edu.udelp.Nodo;

import src.main.java.edu.udelp.Model.Pedidos;

public class Nodo {

    private Pedidos pedido;
    private Nodo siguiente;

    public Nodo(Pedidos pedido) {
        this.pedido = pedido;
        this.siguiente = null;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

