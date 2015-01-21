package ua.dp.mign.concurrent.locks.conditions;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class RailwayStation {
    private static Lock station = new ReentrantLock();
    private static Condition joeArrival = station.newCondition();

    static class Train extends Thread {
        public Train(String name) {
            this.setName(name);
        }
        public void run() {
            station.lock();
            try {
                System.out.println(getName() + ": I've arrived in station ");
                if(getName().startsWith("IC1122")) {
                    joeArrival.signalAll();
                }
            } finally {
                station.unlock();
            }
        }
    }
    
    static class WaitForJoe extends Thread {
        public void run() {
            System.out.println("Waiting in the station for IC1122 in which Joe is coming.");
            station.lock();
            try {
                joeArrival.await();
                System.out.println("Pick up Joe and go home");
            } catch(InterruptedException ie) {
                ie.printStackTrace();
            } finally {
                station.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new WaitForJoe().start();
        new Train("IC1234 - Paris to Munich").start();
        new Train("IC2211 - Paris to Madrid").start();
        new Train("IC1122 - Madrid to Paris").start();
        new Train("IC4321 - Munich to Paris").start();
    }
}
