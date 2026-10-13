package src.main.java.edu.udelp.Nodo;

public class Nodo <T> {
    //  === ATRIBUTOS ===
    private T dato;
    private Nodo<T> enlace;

    // === CONSTRUCTOR ===
    public Nodo(T dato) {
        this.dato = dato;
    }

    // === GETTERS & SETTERS
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    // Get Enlace: obetener el enlace del nodo
    public Nodo<T> getEnlace() {
        return enlace;
    }

    // Set Enlace: darle un nuevo valor al enlace
    public void setEnlace(Nodo<T> enlace) {
        this.enlace = enlace;
    }

    // === TO STRING ===
    @Override
    public String toString() {
        if (null == enlace) {
            return dato + "";
        }
        return dato + " - " + enlace.toString();
    }
}


