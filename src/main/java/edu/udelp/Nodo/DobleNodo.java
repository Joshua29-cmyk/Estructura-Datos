package src.main.java.edu.udelp.Nodo;

public class DobleNodo <T>{

    private Nodo<T> izquierda;
    private Nodo<T> derecha;
    private T valor;

    public Nodo<T> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo<T> izquierda) {
        this.izquierda = izquierda;
    }
}
