package src.main.java.edu.udelp.repaso.colasdeprioridad.Ejercicio3_UrgenciasMedicas;

public class NodoPaciente {
    // Almacena la información del paciente.
    Paciente paciente;

    // Referencia al siguiente paciente.
    NodoPaciente siguiente;

    public NodoPaciente(Paciente paciente) {
        this.paciente = paciente;
        this.siguiente = null;
    }
}
