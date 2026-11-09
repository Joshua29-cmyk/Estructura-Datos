package src.main.java.edu.udelp.repaso.colasdeprioridad.Ejercicio4_PlanificadorProcesos;

public class Proceso {

    private String id;
    private int prioridad;
    private int ciclos;

    public Proceso(String id, int prioridad, int ciclos) {
        this.id = id;
        this.prioridad = prioridad;
        this.ciclos = ciclos;
    }

    public String getId() {
        return id;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getCiclos() {
        return ciclos;
    }

    public void ejecutar(int cantidad) {
        ciclos -= cantidad;
    }

    @Override
    public String toString() {
        return id + " | Prioridad: " + prioridad +
                " | Ciclos restantes: " + ciclos;
    }
}
