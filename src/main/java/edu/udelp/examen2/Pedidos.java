package src.main.java.edu.udelp.examen2;

public class Pedidos {

    private int Numeropedido;
    private String cliente;
    private int Cantidadpedidos;
    private String estado;

    public Pedidos(int Numeropedido, String cliente, int Cantidadpedidos, String estado){

        this.Numeropedido = Numeropedido;
        this.cliente = cliente;
        this.Cantidadpedidos = Cantidadpedidos;
        this.estado = estado;

    }

    public int getCantidadpedidos() {
        return Cantidadpedidos;
    }

    public int getNumeropedido(int numeropedido) {
        return Numeropedido;
    }

    public String getCliente() {
        return cliente;
    }


    public String getestado(){
        return estado;
    }

    @Override
    public String toString(){return Numeropedido + " | " + cliente + " | " + Cantidadpedidos + " | " + estado;}

    public void getestado(String entregado) {

    }

    public int getNumeroPedido() {
            return 0;
    }
}

