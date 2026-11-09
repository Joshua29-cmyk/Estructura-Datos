package src.main.java.edu.udelp.repaso.listasDoblementeEnlazada.Ejercicio8_EditorTexto;

public class ListaEditor <T> {

    private NodoEditor<T> inicio;
    private NodoEditor<T> fin;
    private int cantidad;

    public ListaEditor() {
        inicio = null;
        fin = null;
        cantidad = 0;
    }

    // Agrego un elemento en una posición específica.
    public void add(int posicion, T dato) {

        if (posicion < 0 || posicion > cantidad) {
            throw new IndexOutOfBoundsException("Posicion no valida");
        }

        NodoEditor<T> nuevo = new NodoEditor<>(dato);

        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;

        } else if (posicion == 0) {
            nuevo.siguiente = inicio;
            inicio.anterior = nuevo;
            inicio = nuevo;

        } else if (posicion == cantidad) {
            fin.siguiente = nuevo;
            nuevo.anterior = fin;
            fin = nuevo;

        } else {
            NodoEditor <T> actual = inicio;

            for (int i = 0; i < posicion; i++) {
                actual = actual.siguiente;
            }

            nuevo.anterior = actual.anterior;
            nuevo.siguiente = actual;

            actual.anterior.siguiente = nuevo;
            actual.anterior = nuevo;
        }

        cantidad++;
    }

    // Elimino un elemento de la lista.
    public T remove(int posicion) {

        if (posicion < 0 || posicion >= cantidad) {
            throw new IndexOutOfBoundsException("Posicion no valida");
        }

        NodoEditor<T> actual = inicio;

        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }

        if (actual == inicio) {
            inicio = actual.siguiente;

            if (inicio != null) {
                inicio.anterior = null;
            }

        } else if (actual == fin) {
            fin = actual.anterior;
            fin.siguiente = null;

        } else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }

        cantidad--;

        if (cantidad == 0) {
            inicio = null;
            fin = null;
        }

        return actual.dato;
    }

    // Obtengo un elemento por su posición.
    public T get(int posicion) {

        if (posicion < 0 || posicion >= cantidad) {
            throw new IndexOutOfBoundsException("Posicion no valida");
        }

        NodoEditor<T> actual = inicio;

        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }

        return actual.dato;
    }

    // Obtengo la cantidad de elementos.
    public int size() {
        return cantidad;
    }

    // Verifico si la lista esta vacia.
    public boolean isEmpty() {
        return cantidad == 0;
    }
}