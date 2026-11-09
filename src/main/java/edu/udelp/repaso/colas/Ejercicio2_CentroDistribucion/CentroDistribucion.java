package src.main.java.edu.udelp.repaso.colas.Ejercicio2_CentroDistribucion;

public class CentroDistribucion {

    // Se crean tres colas independientes, una para cada estación.
    private ColaPaquetes[] estaciones;

    public CentroDistribucion() {

        estaciones = new ColaPaquetes[3];

        for (int i = 0; i < 3; i++) {
            estaciones[i] = new ColaPaquetes();
        }
    }

    // Busca la estación que tenga menor carga de trabajo.
    public int buscarEstacionDisponible() {

        int menor = 0;

        for (int i = 1; i < 3; i++) {

            if (estaciones[i].obtenerCarga() <
                    estaciones[menor].obtenerCarga()) {

                menor = i;
            }
        }

        // Se suma uno porque las estaciones se muestran desde el número 1.
        return menor + 1;
    }

    // Asigna el paquete a la estación con menor carga.
    public void registrarPaquete(Paquete paquete) {

        int numeroEstacion = buscarEstacionDisponible();

        estaciones[numeroEstacion - 1].agregar(paquete);

        System.out.println("Paquete registrado correctamente.");
        System.out.println("Asignado a la estacion: " + numeroEstacion);
    }

    // Procesa un paquete completo de cada estación.
    public void procesarCiclo() {

        System.out.println("\n===== PROCESAMIENTO DEL CICLO =====");

        for (int i = 0; i < 3; i++) {

            System.out.println("\nEstacion " + (i + 1));

            if (estaciones[i].estaVacia()) {

                System.out.println("No hay paquetes para procesar.");

            } else {

                Paquete paquete = estaciones[i].retirar();

                System.out.println("Paquete procesado:");
                paquete.mostrar();
            }
        }
    }

    // Transfiere todos los paquetes de una estación a otra,
    // conservando el orden en que fueron registrados.
    public void transferirPaquetes(int origen, int destino) {

        if (origen < 1 || origen > 3 ||
                destino < 1 || destino > 3 || origen == destino) {

            System.out.println("Estaciones no validas.");
            return;
        }

        ColaPaquetes colaOrigen = estaciones[origen - 1];
        ColaPaquetes colaDestino = estaciones[destino - 1];

        if (colaOrigen.estaVacia()) {
            System.out.println("La estacion de origen esta vacia.");
            return;
        }

        while (!colaOrigen.estaVacia()) {

            Paquete paquete = colaOrigen.retirar();

            colaDestino.agregar(paquete);
        }

        System.out.println("Paquetes transferidos correctamente.");
    }

    // Muestra los paquetes y la carga de trabajo de cada estación.
    public void mostrarEstado() {

        System.out.println("\n===== ESTADO DE LAS ESTACIONES =====");

        for (int i = 0; i < 3; i++) {

            System.out.println("\nESTACION " + (i + 1));

            estaciones[i].mostrarPaquetes();

            System.out.println("Carga pendiente: "
                    + estaciones[i].obtenerCarga() + " minutos");
        }
    }
}
