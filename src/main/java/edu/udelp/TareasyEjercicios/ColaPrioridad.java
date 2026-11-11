
package src.main.java.edu.udelp.TareasyEjercicios;

public class ColaPrioridad {

    NodoPrioridadNumerica frente;
    int cantidad;

    public ColaPrioridad() {

        frente = null;
        cantidad = 0;
    }

    // Agregar numero segun su prioridad
    public void add(int numero, int prioridad) {

        NodoPrioridadNumerica nuevo = new NodoPrioridadNumerica(numero, prioridad);

        if (frente == null || prioridad < frente.prioridad) {

            nuevo.siguiente = frente;
            frente = nuevo;

        } else {

            NodoPrioridadNumerica actual = frente;

            while (actual.siguiente != null &&
                    actual.siguiente.prioridad <= prioridad) {

                actual = actual.siguiente;
            }

            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }

        cantidad++;
    }

    // Atender numero
    public int remove() {

        if (frente == null) {
            return -1;
        }

        int numero = frente.numero;

        frente = frente.siguiente;
        cantidad--;

        return numero;
    }

    // Revisar si esta vacia
    public boolean isEmpty() {

        return frente == null;
    }

    // Mostrar cola
    public void mostrar() {

        if (frente == null) {
            System.out.println("La cola esta vacia.");
            return;
        }

        NodoPrioridadNumerica actual = frente;

        while (actual != null) {

            System.out.println("Numero: " + actual.numero +
                    " Prioridad: " + actual.prioridad);

            actual = actual.siguiente;
        }
    }

    // Mostrar cantidad
    public int size() {

        return cantidad;
    }


}

