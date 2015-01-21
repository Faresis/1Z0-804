package ua.dp.mign.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

class ATMRoom {
    public static void main(String[] args) {
        Lock machine = new ReentrantLock();

        new Person(machine, "Mickey");
        new Person(machine, "Donald");
        new Person(machine, "Tom");
        new Person(machine, "Jerry");
        new Person(machine, "Casper");
    }
}

class Person extends Thread {
    private Lock machine;

    public Person(Lock machine, String name) {
        this.machine = machine;
        this.setName(name);
        this.start();
    }

    public void run() {
        try {
            System.out.printf("%s is waiting to access an ATM machine%n", getName());
            machine.lock();
            System.out.printf("%s is accessing ATM machine%n", getName());
            Thread.sleep(1000);
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            System.out.printf("%s is done using the ATM machine%n", getName());
            machine.unlock();
        }
    }
}
