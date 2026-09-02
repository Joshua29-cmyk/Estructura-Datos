package edu.udelp.Nodo;

import edu.udelp.Model.Paqueteria;

public class NodoPaqueteria {

    public Paqueteria paquete;
    public NodoPaqueteria siguiente;
    public Paqueteria NodoPaquete;

    public NodoPaqueteria(Paqueteria paquete) {
        this.paquete = paquete;
        this.siguiente = null;
    }
}
