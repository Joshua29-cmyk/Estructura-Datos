package src.main.java.edu.udelp.Model;


public class Pedidos {

    private int numero;
    private String cliente;
    private String platillo;
    private int cantidad;
    private int tiempoEstimado; // (en minutos)

    public Pedidos(int numero, String cliente, String platillo, int cantidad, int tiempoEstimado) {
        this.numero = numero;
        this.cliente = cliente;
        this.platillo = platillo;
        this.cantidad = cantidad;
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public String getPlatillo() {
        return platillo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }


    public void mostrarDetalle() {
        System.out.println("Pedido: " + numero);
        System.out.println("Cliente: " + cliente);
        System.out.println("Platillo: " + platillo);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Tiempo estimado: " + tiempoEstimado + " minutos");
    }


    @Override
    public String toString() {
        return numero + " - " + platillo;
    }
}
