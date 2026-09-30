package src.main.java.edu.udelp.Nodo;

public class PriorityNodo<T> {

    private T dato;
    private boolean priority;
    private PriorityNodo<T> enlace;

    // Constructor
    public PriorityNodo(T dato, boolean priority) {
        this.dato = dato;
        this.priority = priority;
        this.enlace = null;
    }

    // Getters y Setters
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public PriorityNodo<T> getEnlace() {
        return enlace;
    }

    public void setEnlace(PriorityNodo<T> enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return dato + " (" + (priority ? "VIP" : "Normal") + ")";
    }
}
