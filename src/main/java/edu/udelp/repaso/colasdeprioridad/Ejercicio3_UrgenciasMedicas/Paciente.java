package src.main.java.edu.udelp.repaso.colasdeprioridad.Ejercicio3_UrgenciasMedicas;

public class Paciente {

    private String nombre;
    private int edad;
    private int prioridad;
    private int llegada;

    public Paciente(String nombre, int edad, int prioridad, int llegada) {
        this.nombre = nombre;
        this.edad = edad;
        this.prioridad = prioridad;
        this.llegada = llegada;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getLlegada() {
        return llegada;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return nombre + " | Edad: " + edad +
                " | Prioridad: " + prioridad +
                " | Llegada: " + llegada;
    }
}