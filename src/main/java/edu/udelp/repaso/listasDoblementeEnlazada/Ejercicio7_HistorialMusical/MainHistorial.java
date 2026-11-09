package src.main.java.edu.udelp.repaso.listasDoblementeEnlazada.Ejercicio7_HistorialMusical;

import java.util.Scanner;

public class MainHistorial {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        ListaDoble<Cancion> lista = new ListaDoble<>();

        int actual = -1;
        int opcion;

        do {
            System.out.println("\n=== HISTORIAL DE REPRODUCCION ===");
            System.out.println("1. Agregar cancion");
            System.out.println("2. Siguiente cancion");
            System.out.println("3. Cancion anterior");
            System.out.println("4. Insertar antes de una cancion");
            System.out.println("5. Insertar despues de una cancion");
            System.out.println("6. Eliminar cancion");
            System.out.println("7. Mostrar cancion actual y vecinas");
            System.out.println("8. Mostrar playlist");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("ID: ");
                    String id = entrada.nextLine();

                    System.out.print("Titulo: ");
                    String titulo = entrada.nextLine();

                    System.out.print("Artista: ");
                    String artista = entrada.nextLine();

                    Cancion nueva = new Cancion(id, titulo, artista);

                    lista.add(lista.size(), nueva);

                    if (actual == -1) {
                        actual = 0;
                    }

                    System.out.println("Cancion agregada.");
                    break;

                case 2:
                    if (actual == -1 || actual + 1 >= lista.size()) {
                        System.out.println("No hay una siguiente cancion.");
                    } else {
                        actual++;
                        System.out.println("Reproduciendo: " + lista.get(actual));
                    }
                    break;

                case 3:
                    if (actual <= 0) {
                        System.out.println("No hay una cancion anterior.");
                    } else {
                        actual--;
                        System.out.println("Reproduciendo: " + lista.get(actual));
                    }
                    break;

                case 4:
                case 5:
                    System.out.print("ID de la cancion de referencia: ");
                    String referencia = entrada.nextLine();

                    int posicion = -1;

                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getId().equalsIgnoreCase(referencia)) {
                            posicion = i;
                            break;
                        }
                    }

                    if (posicion == -1) {
                        System.out.println("Cancion no encontrada.");
                    } else {
                        System.out.print("Nuevo ID: ");
                        String nuevoId = entrada.nextLine();

                        System.out.print("Titulo: ");
                        String nuevoTitulo = entrada.nextLine();

                        System.out.print("Artista: ");
                        String nuevoArtista = entrada.nextLine();

                        Cancion cancion = new Cancion(
                                nuevoId, nuevoTitulo, nuevoArtista);

                        int nuevaPosicion;

                        if (opcion == 4) {
                            nuevaPosicion = posicion;
                        } else {
                            nuevaPosicion = posicion + 1;
                        }

                        lista.add(nuevaPosicion, cancion);

                        if (actual >= nuevaPosicion) {
                            actual++;
                        }

                        System.out.println("Cancion insertada.");
                    }
                    break;

                case 6:
                    System.out.print("ID de la cancion a eliminar: ");
                    String eliminar = entrada.nextLine();

                    int eliminarPosicion = -1;

                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getId().equalsIgnoreCase(eliminar)) {
                            eliminarPosicion = i;
                            break;
                        }
                    }

                    if (eliminarPosicion == -1) {
                        System.out.println("Cancion no encontrada.");
                    } else {
                        lista.remove(eliminarPosicion);

                        if (lista.isEmpty()) {
                            actual = -1;
                        } else if (eliminarPosicion < actual) {
                            actual--;
                        } else if (eliminarPosicion == actual) {
                            if (actual >= lista.size()) {
                                actual = lista.size() - 1;
                            }
                        }

                        System.out.println("Cancion eliminada.");
                    }
                    break;

                case 7:
                    if (actual == -1) {
                        System.out.println("No hay canciones.");
                    } else {
                        System.out.println("Cancion actual:");
                        System.out.println(lista.get(actual));

                        if (actual > 0) {
                            System.out.println("Anterior: "
                                    + lista.get(actual - 1));
                        }

                        if (actual + 1 < lista.size()) {
                            System.out.println("Siguiente: "
                                    + lista.get(actual + 1));
                        }
                    }
                    break;

                case 8:
                    if (lista.isEmpty()) {
                        System.out.println("La playlist esta vacia.");
                    } else {
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println(lista.get(i));
                        }
                    }
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        entrada.close();
    }
}
