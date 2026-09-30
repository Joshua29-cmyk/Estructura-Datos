package src.main.java.edu.udelp;

import src.main.java.edu.udelp.queue.BooleanPriorityQueue;

public class MainPriority {

    public static void main(String[] args) {

        BooleanPriorityQueue<Integer> queue = new BooleanPriorityQueue<>();

        queue.enqueue(10, false);
        System.out.println(queue);

        queue.enqueue(20, false);
        System.out.println(queue);

        queue.enqueue(30, true);
        System.out.println(queue);

        queue.enqueue(40, false);
        System.out.println(queue);

        queue.enqueue(50, true);
        System.out.println(queue);
    }
}

