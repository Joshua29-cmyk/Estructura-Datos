package src.main.java.edu.udelp.repaso.listasenlazadas.Ejercicio5_AdministradorEstudiantes;

public class NodoEstudiante {

    Estudiante dato;
    NodoEstudiante siguiente;

    public NodoEstudiante(Estudiante dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
