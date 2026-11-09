package src.main.java.edu.udelp.repaso.listasDoblementeEnlazada.Ejercicio8_EditorTexto;

public class NodoEditor<T> {

    T dato;
    NodoEditor<T> anterior;
    NodoEditor<T> siguiente;

    public NodoEditor(T dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public NodoEditor<T> getAnterior() {
        return anterior;
    }

    public NodoEditor<T> getSiguiente() {
        return siguiente;
    }

    public void setAnterior(NodoEditor<T> anterior) {
        this.anterior = anterior;
    }

    public void setSiguiente(NodoEditor<T> siguiente) {
        this.siguiente = siguiente;
    }
}