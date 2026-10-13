package src.main.java.edu.udelp.list;

public class ArrayListNumerico<T> {


    private T[] array;
    private int size;
    private int increment;

    public ArrayListNumerico(int initialCapacity, int increment) {
        array = (T[]) new Object[initialCapacity];
        size = 0;
        this.increment = increment;
    }

    // Agrego un elemento al final de mi lista
    public void add(T element) {

        // Si mi arreglo está lleno, aumento su capacidad
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length + increment];

            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }

            array = newArray;
        }

        array[size] = element;
        size++;
    }

    // Agrego un elemento en una posición específica
    public void add(int index, T element) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length + increment];

            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }

            array = newArray;
        }

        // Muevo los elementos a la derecha para abrir espacio
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = element;
        size++;
    }

    // Obtengo el elemento de una posición
    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        return array[index];
    }

    // Cambio el elemento de una posición
    public T set(int index, T element) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        T anterior = array[index];
        array[index] = element;

        return anterior;
    }

    // Elimino el elemento de una posición
    public T remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        T anterior = array[index];

        // Recorro los elementos para llenar el espacio vacío
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
        array[size] = null;

        return anterior;
    }

    // Reviso si mi lista está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Obtengo la cantidad de elementos de mi lista
    public int size() {
        return size;
    }

    // Muestro todos los elementos de mi lista
    @Override
    public String toString() {

        String resultado = "[ ";

        for (int i = 0; i < size; i++) {
            resultado += array[i] + " ";
        }

        resultado += "]";

        return resultado;
    }
}

