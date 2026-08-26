package nodo;


public class nodo {
    // ATRIBUTOS
    private int dato;
    private nodo enlace;

    // CONSTRUCTOR
    public nodo(int dato){
        this.dato = dato;
    }

    // MODIFICADOR (no sé si se llama así)
    public int getDato(){
        return dato;
    }

    public void setDato(int dato){
        this.dato = dato;
    }

    public nodo getEnalce(){
        return enlace;
    }

    public void setEnlace(nodo enlace){
        this.enlace = enlace;
    }

    public String toString(){
        return dato + " - " + enlace.toString();
    }
}