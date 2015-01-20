package ua.dp.mign.concurrent.collections;

import java.util.PriorityQueue;

class PriorityQueueExample {
    public static void main(String[] args) {
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        new Thread() {
            public void run() {
                System.out.println("The removed element is: " + priorityQueue.remove());
            }
        }.start();

        new Thread() {
            public void run() {
                priorityQueue.add(10);
                System.out.println("Successfully added and element to the queue");
            }
        }.start();
    }
}
