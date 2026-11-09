package src.main.java.edu.udelp.repaso.listasDoblementeEnlazada.Ejercicio7_HistorialMusical;

public class ListaDoble<T> {

    private static class NodoDoble<T> {

        T dato;
        NodoDoble<T> anterior;
        NodoDoble<T> siguiente;

        public NodoDoble(T dato) {
            this.dato = dato;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;
    private int cantidad;

    public ListaDoble() {
        inicio = null;
        fin = null;
        cantidad = 0;
    }

    // Agrego un elemento al inicio.
    public void add(Object dato) {
        add(0, dato);
    }

    // Inserto un elemento en la posición indicada.
    public void add(int index, Object dato) {

        if (index < 0 || index > cantidad) {
            throw new IndexOutOfBoundsException("Posicion no valida");
        }

        NodoDoble<T> nuevo = new NodoDoble<>((T) dato);

        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else if (index == 0) {
            nuevo.siguiente = inicio;
            inicio.anterior = nuevo;
            inicio = nuevo;
        } else if (index == cantidad) {
            fin.siguiente = nuevo;
            nuevo.anterior = fin;
            fin = nuevo;
        } else {
            NodoDoble<T> actual = buscarNodo(index);

            nuevo.anterior = actual.anterior;
            nuevo.siguiente = actual;

            actual.anterior.siguiente = nuevo;
            actual.anterior = nuevo;
        }

        cantidad++;
    }

    // Elimino el elemento y conecto sus nodos vecinos.
    public T remove(int index) {

        if (index < 0 || index >= cantidad) {
            return null;
        }

        NodoDoble<T> actual = buscarNodo(index);

        if (actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
        } else {
            inicio = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        } else {
            fin = actual.anterior;
        }

        cantidad--;

        return actual.dato;
    }

    // Consulto el elemento de una posición.
    public T get(int index) {
        return buscarNodo(index).dato;
    }

    // Reemplazo el dato de una posición.
    public void set(int index, Object dato) {
        buscarNodo(index).dato = (T) dato;
    }

    public int size() {
        return cantidad;
    }

    public boolean isEmpty() {
        return cantidad == 0;
    }

    // Busco el nodo desde el extremo más cercano.
    private NodoDoble<T> buscarNodo(int index) {

        if (index < 0 || index >= cantidad) {
            throw new IndexOutOfBoundsException("Posicion no valida");
        }

        NodoDoble<T> actual;

        if (index < cantidad / 2) {
            actual = inicio;

            for (int i = 0; i < index; i++) {
                actual = actual.siguiente;
            }
        } else {
            actual = fin;

            for (int i = cantidad - 1; i > index; i--) {
                actual = actual.anterior;
            }
        }

        return actual;
    }
}