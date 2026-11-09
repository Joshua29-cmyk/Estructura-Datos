package src.main.java.edu.udelp.repaso.listasenlazadas.Ejercicio5_AdministradorEstudiantes;
public class Estudiante{
    private String matricula;
    private String nombre;
    private double promedio;

    public Estudiante(String matricula, String nombre, double promedio) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula +
                " | Nombre: " + nombre +
                " | Promedio: " + promedio;
    }
}