package src.main.java.edu.udelp.examen2;

public class ColaPedidos {

    private NodoPedido frente;
    private NodoPedido fin;

    public ColaPedidos(){
        frente = null;
        fin = null;

    }
    public void agregar(Pedidos pedidos){

        NodoPedido nuevo = new NodoPedido(pedidos);

        if (frente == null){
            frente = nuevo;
            fin = nuevo;
        }else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }


    }
    public Pedidos retirar(Pedidos pedidos){
        if (frente == null){
            frente = frente.siguiente;
        }
        pedidos = frente.pedidos;
        frente = frente .siguiente;

        if (frente == null){
            fin = null;
        }
        return pedidos;

    }
    public boolean estaVacio(){
        return frente == null;

    }
    public void mostrarPedidos(){
        if (frente == null){
            System.out.println("No existe el pedido");
            return;
        }

        NodoPedido actual = frente;
        actual.siguiente.mostrar();
        System.out.println(actual.pedidos);

        actual = actual.siguiente;
    }



}
