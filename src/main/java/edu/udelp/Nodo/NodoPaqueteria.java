package src.main.java.edu.udelp.Nodo;

import src.main.java.edu.udelp.Model.Paqueteria;

public class NodoPaqueteria {

    public Paqueteria paquete;
    public NodoPaqueteria siguiente;
    public Paqueteria NodoPaquete;

    public <Paqueteria extends src.main.java.edu.udelp.Model.Paqueteria> NodoPaqueteria(Paqueteria paquete) {
        this.paquete = paquete;
        this.siguiente = null;
    }

    public void setSiguiente(NodoPaqueteria siguiente) {
        this.siguiente = siguiente;
    }

    public NodoPaqueteria getSiguiente() {
        return siguiente;
    }
}
