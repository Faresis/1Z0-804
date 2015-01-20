package ua.dp.mign.concurrent.phaser;

import java.util.concurrent.Phaser;

public class ProcessOrder {
    public static void main(String[] args) throws InterruptedException {
        final int numOfOrders = 8;
        Phaser deliveryOrder = new Phaser() {
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("Deliver food item no." + phase);
                return phase >= numOfOrders || registeredParties == 0;
            }
        };

        System.out.println("Starting to process the delivery order.");

        new Worker(deliveryOrder, "Cook");
        new Worker(deliveryOrder, "Helper");
        new Worker(deliveryOrder, "Attendant");

        // wait for orders to be processed
        deliveryOrder.register();
        while(!deliveryOrder.isTerminated()) {
            deliveryOrder.arriveAndAwaitAdvance();
        }

        System.out.println("Delivery order completed... give it to the customer");
    }
}

class Worker extends Thread {
    Phaser deliveryOrder;
    Worker(Phaser deliveryOrder, String name) {
        this.deliveryOrder = deliveryOrder;
        this.setName(name);
        deliveryOrder.register();
        start();
    }

    public void run() {
        while(!deliveryOrder.isTerminated()) {
            System.out.printf("\t%s doing his work for order no. %d%n",
                              getName(),
                              deliveryOrder.getPhase());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            deliveryOrder.arriveAndAwaitAdvance();
        }
    }
}
