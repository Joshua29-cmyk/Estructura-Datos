package src.main.java.edu.udelp.repaso.listasenlazadas.Ejercicio5_AdministradorEstudiantes;

public class ListaEstudiantes {

    private NodoEstudiante inicio;
    private int cantidad;

    public ListaEstudiantes() {
        inicio = null;
        cantidad = 0;
    }

    // Inserto un estudiante al inicio de la lista.
    public void insertarInicio(Estudiante estudiante) {
        NodoEstudiante nuevo = new NodoEstudiante(estudiante);

        nuevo.siguiente = inicio;
        inicio = nuevo;
        cantidad++;
    }

    // Agrego un estudiante al final.
    public void insertarFinal(Estudiante estudiante) {
        NodoEstudiante nuevo = new NodoEstudiante(estudiante);

        if (inicio == null) {
            inicio = nuevo;
        } else {
            NodoEstudiante actual = inicio;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nuevo;
        }

        cantidad++;
    }

    // Inserto un estudiante en una posición determinada.
    public void insertarPosicion(Estudiante estudiante, int posicion) {
        if (posicion < 0 || posicion > cantidad) {
            System.out.println("Posicion invalida.");
            return;
        }

        if (posicion == 0) {
            insertarInicio(estudiante);
            return;
        }

        NodoEstudiante nuevo = new NodoEstudiante(estudiante);
        NodoEstudiante actual = inicio;

        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.siguiente;
        }

        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
        cantidad++;
    }

    // Elimino un estudiante utilizando su matrícula.
    public void eliminarMatricula(String matricula) {
        if (inicio == null) {
            System.out.println("La lista esta vacia.");
            return;
        }

        if (inicio.dato.getMatricula().equals(matricula)) {
            inicio = inicio.siguiente;
            cantidad--;
            System.out.println("Estudiante eliminado.");
            return;
        }

        NodoEstudiante actual = inicio;

        while (actual.siguiente != null &&
                !actual.siguiente.dato.getMatricula().equals(matricula)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente == null) {
            System.out.println("Matricula no encontrada.");
        } else {
            actual.siguiente = actual.siguiente.siguiente;
            cantidad--;
            System.out.println("Estudiante eliminado.");
        }
    }

    // Busco un estudiante por su nombre.
    public Estudiante buscarNombre(String nombre) {
        NodoEstudiante actual = inicio;

        while (actual != null) {
            if (actual.dato.getNombre().equalsIgnoreCase(nombre)) {
                return actual.dato;
            }

            actual = actual.siguiente;
        }

        return null;
    }

    // Ordeno los estudiantes de mayor a menor promedio.
    public void ordenarPromedio() {
        if (inicio == null || inicio.siguiente == null) {
            return;
        }

        boolean cambio;

        do {
            cambio = false;
            NodoEstudiante actual = inicio;

            while (actual.siguiente != null) {
                if (actual.dato.getPromedio() <
                        actual.siguiente.dato.getPromedio()) {

                    Estudiante temporal = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temporal;

                    cambio = true;
                }

                actual = actual.siguiente;
            }

        } while (cambio);
    }

    // Calculo el promedio general del grupo.
    public double promedioGeneral() {
        if (inicio == null) {
            return 0;
        }

        double suma = 0;
        NodoEstudiante actual = inicio;

        while (actual != null) {
            suma += actual.dato.getPromedio();
            actual = actual.siguiente;
        }

        return suma / cantidad;
    }

    // Muestro a los estudiantes que superan el promedio general.
    public void mostrarSuperiores() {
        if (inicio == null) {
            System.out.println("La lista esta vacia.");
            return;
        }

        double promedio = promedioGeneral();
        NodoEstudiante actual = inicio;

        System.out.println("Promedio general: " + promedio);
        System.out.println("Estudiantes que superan el promedio:");

        while (actual != null) {
            if (actual.dato.getPromedio() > promedio) {
                System.out.println(actual.dato);
            }

            actual = actual.siguiente;
        }
    }

    // Muestro todos los estudiantes registrados.
    public void mostrar() {
        if (inicio == null) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        NodoEstudiante actual = inicio;

        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}
