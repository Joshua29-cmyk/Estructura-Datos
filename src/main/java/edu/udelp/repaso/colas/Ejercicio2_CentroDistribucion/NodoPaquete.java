package src.main.java.edu.udelp.repaso.colas.Ejercicio2_CentroDistribucion;

public class NodoPaquete {

    // Almacena la información del paquete.
    Paquete paquete;

    // Referencia al siguiente paquete de la cola.
    NodoPaquete siguiente;

    public NodoPaquete(Paquete paquete) {
        this.paquete = paquete;
        this.siguiente = null;
    }
}
