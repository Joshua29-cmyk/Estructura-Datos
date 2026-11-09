package src.main.java.edu.udelp.repaso.colasdeprioridad.Ejercicio4_PlanificadorProcesos;

public class NodoProceso {

    // Almacena la información del proceso.
    Proceso proceso;

    // Referencia al siguiente proceso de la cola.
    NodoProceso siguiente;

    public NodoProceso(Proceso proceso) {
        this.proceso = proceso;
        this.siguiente = null;
    }
}
