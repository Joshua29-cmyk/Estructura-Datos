package src.main.java.edu.udelp.Model;

public class Paqueteria {


    private int id;
    private String descripcion;
    private double peso;

    public Paqueteria(int id, String descripcion, double peso) {
        this.id = id;
        this.descripcion = descripcion;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nDescripción: " + descripcion +
                "\nPeso: " + peso + " kg";
    }
}

