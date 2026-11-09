package src.main.java.edu.udelp.examen2;

public class NodoPedido {

    public NodoPedido siguiente ;
    Pedidos pedidos;

    NodoPedido nodoPedido;

    public NodoPedido(Pedidos pedidos) {
        this.pedidos = pedidos;
        this.nodoPedido = null;
    }

    public void mostrar() {

    }
}
