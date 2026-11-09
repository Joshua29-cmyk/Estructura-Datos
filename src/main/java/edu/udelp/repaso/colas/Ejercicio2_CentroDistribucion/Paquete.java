package src.main.java.edu.udelp.repaso.colas.Ejercicio2_CentroDistribucion;

public class Paquete {

    private String id;
    private String destino;
    private int minutos;

    public Paquete(String id, String destino, int minutos) {
        this.id = id;
        this.destino = destino;
        this.minutos = minutos;
    }

    public String getId() {
        return id;
    }

    public int getMinutos() {
        return minutos;
    }

    @Override
    public String toString() {
        return id + " | " + destino + " | " + minutos + " minutos";
    }
}
