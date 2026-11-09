package src.main.java.edu.udelp.repaso.colas.Ejercicio1_TurnosBancarios;

public class Cliente {

    private String turno;
    private String nombre;
    private String tramite;

    public Cliente(String turno, String nombre, String tramite) {
        this.turno = turno;
        this.nombre = nombre;
        this.tramite = tramite;
    }

    public String getTurno() {
        return turno;
    }

    @Override
    public String toString() {
        return turno + " | " + nombre + " | " + tramite;
    }
}
