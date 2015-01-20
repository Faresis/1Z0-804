package ua.dp.mign.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicVariableTest {
    private static Integer integer = new Integer(0);
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    static class IncrementInteger extends Thread {
        public void run() {
            System.out.println("Incremented value of integer is: " + ++integer);
        }
    }

    static class AtomicIntegerIncrement extends Thread {
        public void run() {
            System.out.println("Incremented value of atomic integers is: " + atomicInteger.incrementAndGet());
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            new IncrementInteger().start();
            new AtomicIntegerIncrement().start();
        }
    }
}
