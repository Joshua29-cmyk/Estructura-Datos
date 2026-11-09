package src.main.java.edu.udelp.repaso.colas.Ejercicio1_TurnosBancarios;

public class NodoCliente {

    // Guarda la información del cliente.
    Cliente cliente;

    // Referencia al siguiente nodo de la cola.
    NodoCliente siguiente;

    public NodoCliente(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }
}
