    package edu.udelp.Nodo;             

public class Nodo {

    private int dato;
    private Nodo enlace;

    public Nodo(int dato) {
        this.dato = dato;
        this.enlace = null;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

    public String toString() {
        return dato + " - " +  enlace.toString();
    }
}