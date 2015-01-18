package ua.dp.mign.concurrent.semaphore;

import java.util.concurrent.Semaphore;

class ATMRoom {
    public static void main(String[] args) {
        Semaphore machines = new Semaphore(2);

        new Person(machines, "Mickey");
        new Person(machines, "Donald");
        new Person(machines, "Tom");
        new Person(machines, "Jerry");
        new Person(machines, "Casper");
    }
}

class Person extends Thread {
    private Semaphore machines;

    public Person(Semaphore machines, String name) {
        this.machines = machines;
        this.setName(name);
        this.start();
    }

    public void run() {
        try {
            System.out.printf("%s is waiting to access an ATM machine%n", getName());
            machines.acquire();
            System.out.printf("%s is accessing ATM machine%n", getName());
            Thread.sleep(1000);
            System.out.printf("%s is done using the ATM machine%n", getName());
            machines.release();

        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
