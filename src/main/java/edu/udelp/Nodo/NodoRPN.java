package src.main.java.edu.udelp.Nodo;

public class NodoRPN {

    private Object dato;
        private edu.udelp.Nodo siguiente;

        public NodoRPN(Object dato) {
            this.dato = dato;
            this.siguiente = null;
        }

        public Object getDato() {
            return dato;
        }

        public void setDato(Object dato) {
            this.dato = dato;
        }

        public edu.udelp.Nodo.Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(edu.udelp.Nodo.Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }

