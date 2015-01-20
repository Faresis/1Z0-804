package ua.dp.mign.concurrent.collections;

import java.util.concurrent.PriorityBlockingQueue;

class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        final PriorityBlockingQueue<Integer> priorityQueue = new PriorityBlockingQueue<>();
        new Thread() {
            public void run() {
                try {
                // use blocking call to synchronize
                System.out.println("The removed element is: " + priorityQueue.take());
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
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
