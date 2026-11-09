package src.main.java.edu.udelp.repaso.colas.Ejercicio2_CentroDistribucion;

public class ColaPaquetes {

    // Referencias al primer y último paquete.
    private NodoPaquete frente;
    private NodoPaquete fin;

    // Guarda la suma de los minutos pendientes.
    private int cargaTrabajo;

    public ColaPaquetes() {
        frente = null;
        fin = null;
        cargaTrabajo = 0;
    }

    // Agrega un paquete al final de la cola.
    public void agregar(Paquete paquete) {

        NodoPaquete nuevo = new NodoPaquete(paquete);

        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }

        cargaTrabajo += paquete.getMinutos();
    }

    // Retira el primer paquete de la cola.
    public Paquete retirar() {

        if (frente == null) {
            return null;
        }

        Paquete paquete = frente.paquete;

        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        cargaTrabajo -= paquete.getMinutos();

        return paquete;
    }

    // Devuelve los minutos pendientes de procesamiento.
    public int obtenerCarga() {
        return cargaTrabajo;
    }

    // Comprueba si la estación tiene paquetes pendientes.
    public boolean estaVacia() {
        return frente == null;
    }

    // Muestra todos los paquetes registrados en la estación.
    public void mostrarPaquetes() {

        if (frente == null) {
            System.out.println("No hay paquetes pendientes.");
            return;
        }

        NodoPaquete actual = frente;

        while (actual != null) {
            actual.paquete.mostrar();
            System.out.println("--------------------");

            actual = actual.siguiente;
        }
    }
}
