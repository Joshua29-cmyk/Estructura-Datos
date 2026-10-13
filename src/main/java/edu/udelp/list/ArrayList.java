package src.main.java.edu.udelp.list;

import edu.udelp.Exception.UdelpException;

public class ArrayList <T> {

    //declarar mis arreglos
    private T[] array;

    private int size;

    private int increment;

    public ArrayList(int InicialCapacity, int increment){

        array = (T[]) new Object[InicialCapacity];
        size = 0;
        this.increment = increment;

    }
    //empezar hacer los metodos del mas sencillo al mas complicado
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }//no condunfir el .lenght ya que ese nos dara el tamaño del arreglo con le size

    public void add(T element){

        array[size++] = element;
        size++;
        resize();
    }
    public void add(int index,T element){// el index es mi posicion en mi lista
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        for (int i = size; i> index; i--){
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
        resize();

    }

    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new UdelpException("Index out of bounds");
        }
        T aux = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size++;

        return aux;
    }
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new UdelpException("Index out of bounds");
        }
        return array[index];
    }
    public T set(int index, T element){
        if (index < 0 || index > size) {
            throw new UdelpException("Index out of bounds");
        }
        T aux = array[index];
        array[index] = element;

        return aux;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append(array[i].toString()).append(" ");
        }
        return sb.toString();
    }

    //Crear una nueva clase para agregar un digito nuevo aunque mi lista ya este llena y no marque error
    private void resize(){
        T[] newArray = (T[]) new Object[array.length + increment];
        for(int i = 0; i < size; i++){
             newArray[i] = array[i];
        }
        array = newArray;
    }

    //para el add(int,object) va ir recorriendo la fila mas no sobre escribirla (lista normal:10,20,30)(lista ya recorrida:10,40,20,30)


}


