package edu.udelp.Nodo;

import edu.udelp.Model.Pagina;
public class NodoPagina{

    private Pagina dato;
    private NodoPagina enlace;


    public NodoPagina(Pagina pagina){
        this.dato = pagina;

    }

    public Pagina getPagina() {
        return dato;
    }

    public NodoPagina getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoPagina enlace) {
        this.enlace = enlace;
    }

    public Pagina getDato() {
        return dato;
    }

}