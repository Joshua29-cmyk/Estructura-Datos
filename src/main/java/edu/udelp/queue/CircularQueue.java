package src.main.java.edu.udelp.queue;

import edu.udelp.Exception.UdelpException;

public class CircularQueue <T> {
    private T[] queue;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public CircularQueue(int size) {
        this.queue = (T[]) new Object[size];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        queue[rear] = item;
        rear = (rear + 1) % queue.length;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return element;
    }


    public T peek(){
        if (isEmpty()) {
            throw new UdelpException("Cola vacia");
        }
    }
public String toString(){
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int count = 0;
        while (count < size) {
            sb.append(queue[front].toString().append("<"));
            i = (i + 1) % queue.length;
        }
}
}