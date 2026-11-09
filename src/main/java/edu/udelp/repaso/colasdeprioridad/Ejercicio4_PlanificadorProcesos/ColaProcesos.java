package src.main.java.edu.udelp.repaso.colasdeprioridad.Ejercicio4_PlanificadorProcesos;

public class ColaProcesos {

    // Se utilizan tres colas independientes.
    private NodoProceso[] frente;
    private NodoProceso[] fin;

    // Guarda el historial de ejecución y finalización.
    private String historial;
    private String finalizados;

    public ColaProcesos() {
        frente = new NodoProceso[3];
        fin = new NodoProceso[3];

        historial = "";
        finalizados = "";
    }

    // Agrega un proceso al final de su nivel de prioridad.
    public void registrarProceso(String id, int prioridad, int ciclos) {

        if (id == null || id.trim().isEmpty()) {
            System.out.println("El ID del proceso no puede estar vacío.");
            return;
        }

        if (prioridad < 1 || prioridad > 3) {
            System.out.println("La prioridad debe ser de 1 a 3.");
            return;
        }

        if (ciclos <= 0) {
            System.out.println("Los ciclos deben ser mayores a cero.");
            return;
        }

        Proceso nuevoProceso = new Proceso(id, prioridad, ciclos);

        agregar(nuevoProceso);

        System.out.println("Proceso registrado correctamente.");
    }

    // Inserta el proceso al final de la cola correspondiente.
    private void agregar(Proceso proceso) {

        int posicion = proceso.getPrioridad() - 1;

        NodoProceso nuevo = new NodoProceso(proceso);

        if (frente[posicion] == null) {
            frente[posicion] = nuevo;
            fin[posicion] = nuevo;
        } else {
            fin[posicion].siguiente = nuevo;
            fin[posicion] = nuevo;
        }
    }

    // Retira el primer proceso del nivel seleccionado.
    private Proceso retirar(int posicion) {

        if (frente[posicion] == null) {
            return null;
        }

        Proceso proceso = frente[posicion].proceso;

        frente[posicion] = frente[posicion].siguiente;

        if (frente[posicion] == null) {
            fin[posicion] = null;
        }

        return proceso;
    }

    // Busca y ejecuta el proceso de mayor prioridad.
    public void ejecutarTurno() {

        int posicion = -1;

        // Se busca primero la prioridad más alta (índice 0 = Prioridad 1).
        for (int i = 0; i < 3; i++) {
            if (frente[i] != null) {
                posicion = i;
                break;
            }
        }

        if (posicion == -1) {
            System.out.println("No hay procesos pendientes.");
            return;
        }

        // Se retira el primer proceso de su nivel.
        Proceso proceso = retirar(posicion);

        // Se ejecutan máximo tres ciclos por turno.
        int ciclosEjecutados = Math.min(3, proceso.getCiclosPendientes());
        int restantes = proceso.getCiclosPendientes() - ciclosEjecutados;

        proceso.setCiclosPendientes(restantes);

        System.out.println("\n===== EJECUCION DEL PROCESO =====");
        System.out.println("Proceso: " + proceso.getId());
        System.out.println("Prioridad: " + proceso.getPrioridad());
        System.out.println("Ciclos ejecutados: " + ciclosEjecutados);
        System.out.println("Ciclos restantes: " + restantes);

        // Se registra cada ejecución en el historial.
        historial += proceso.getId() + " ejecuta "
                + ciclosEjecutados + " ciclos. Restantes: "
                + restantes + "\n";

        if (restantes > 0) {
            // Si no termina, regresa al final de su nivel.
            agregar(proceso);
            System.out.println("El proceso vuelve a la cola.");
        } else {
            // Si termina, se agrega al registro de finalizados.
            finalizados += proceso.getId() + "\n";
            System.out.println("Proceso finalizado correctamente.");
        }
    }

    // Muestra los procesos pendientes de cada prioridad.
    public void mostrarPendientes() {

        System.out.println("\n===== PROCESOS PENDIENTES =====");

        for (int i = 0; i < 3; i++) {

            System.out.println("\nPrioridad " + (i + 1) + ":");

            if (frente[i] == null) {
                System.out.println("Sin procesos pendientes.");
            } else {

                NodoProceso actual = frente[i];

                while (actual != null) {
                    actual.proceso.mostrar();
                    System.out.println("--------------------");
                    actual = actual.siguiente;
                }
            }
        }
    }

    // Muestra el historial de todos los turnos ejecutados.
    public void mostrarHistorial() {

        System.out.println("\n===== HISTORIAL DE EJECUCION =====");

        if (historial.isEmpty()) {
            System.out.println("Todavia no hay ejecuciones.");
        } else {
            System.out.print(historial);
        }
    }

    // Muestra los procesos que terminaron su ejecución.
    public void mostrarFinalizados() {

        System.out.println("\n===== PROCESOS FINALIZADOS =====");

        if (finalizados.isEmpty()) {
            System.out.println("No hay procesos finalizados.");
        } else {
            System.out.print(finalizados);
        }
    }
}