package src.main.java.edu.udelp.repaso.listasDoblementeEnlazada.Ejercicio7_HistorialMusical;

public class Cancion {

    private String id;
    private String titulo;
    private String artista;

    public Cancion(String id, String titulo, String artista) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " | " + titulo + " | " + artista;
    }
}