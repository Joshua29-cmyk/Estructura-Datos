package src.main.java.edu.udelp.repaso.colasdeprioridad.Ejercicio3_UrgenciasMedicas;

public class ColaPacientes {
    // Referencia al primer paciente de la cola.
    private NodoPaciente frente;

    // Controla el orden de llegada de los pacientes.
    private int contadorLlegada;

    public ColaPacientes() {
        frente = null;
        contadorLlegada = 0;
    }

    // Registra un paciente y le asigna su orden de llegada.
    public void registrarPaciente(String nombre, int edad, int prioridad) {

        if (prioridad < 1 || prioridad > 5) {
            System.out.println("La prioridad debe estar entre 1 y 5.");
            return;
        }

        if (edad <= 0) {
            System.out.println("La edad debe ser mayor a cero.");
            return;
        }

        contadorLlegada++;

        Paciente nuevo = new Paciente(
                nombre, edad, prioridad, contadorLlegada
        );

        insertarOrdenado(nuevo);

        System.out.println("Paciente registrado correctamente.");
    }

    // Inserta al paciente según su prioridad y orden de llegada.
    private void insertarOrdenado(Paciente paciente) {

        NodoPaciente nuevo = new NodoPaciente(paciente);

        // Si la cola está vacía o el nuevo paciente tiene
        // mayor prioridad, se coloca al principio.
        if (frente == null ||
                paciente.getPrioridad() < frente.paciente.getPrioridad()) {

            nuevo.siguiente = frente;
            frente = nuevo;

        } else {

            NodoPaciente actual = frente;

            // Se recorren los nodos hasta encontrar su posición.
            // En caso de empate, se conserva el orden de llegada.
            while (actual.siguiente != null &&
                    (actual.siguiente.paciente.getPrioridad() < paciente.getPrioridad() ||
                            (actual.siguiente.paciente.getPrioridad() == paciente.getPrioridad() &&
                                    actual.siguiente.paciente.getOrdenLlegada() < paciente.getOrdenLlegada()))) {

                actual = actual.siguiente;
            }

            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }
    }

    // Atiende y elimina al paciente con mayor prioridad.
    public void atenderPaciente() {

        if (frente == null) {
            System.out.println("No hay pacientes pendientes.");
            return;
        }

        System.out.println("\nPaciente atendido:");

        frente.paciente.mostrar();

        frente = frente.siguiente;
    }

    // Modifica la prioridad de un paciente y reorganiza la cola.
    public void modificarPrioridad(String nombre, int nuevaPrioridad) {

        if (nuevaPrioridad < 1 || nuevaPrioridad > 5) {
            System.out.println("La prioridad debe estar entre 1 y 5.");
            return;
        }

        NodoPaciente actual = frente;
        NodoPaciente anterior = null;

        // Se busca al paciente por su nombre.
        while (actual != null &&
                !actual.paciente.getNombre().equalsIgnoreCase(nombre)) {

            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("No se encontro al paciente.");
            return;
        }

        // Se conserva el objeto y su orden de llegada.
        Paciente paciente = actual.paciente;

        // Se elimina el nodo de su posición actual.
        if (anterior == null) {
            frente = actual.siguiente;
        } else {
            anterior.siguiente = actual.siguiente;
        }

        // Se actualiza la prioridad sin cambiar su llegada.
        paciente.setPrioridad(nuevaPrioridad);

        // Se vuelve a insertar en la posición correspondiente.
        insertarOrdenado(paciente);

        System.out.println("Prioridad modificada correctamente.");
    }

    // Muestra el orden de atención sin eliminar pacientes.
    public void mostrarOrdenAtencion() {

        if (frente == null) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        NodoPaciente actual = frente;

        System.out.println("\n===== ORDEN DE ATENCION =====");

        while (actual != null) {

            actual.paciente.mostrar();

            System.out.println("----------------------");

            actual = actual.siguiente;
        }
    }
}
