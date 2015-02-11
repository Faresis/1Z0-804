package ua.dp.mign.mock2;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicInteger_54 {
    private static AtomicInteger counter = new AtomicInteger(0);
    static class Decrement extends Thread {
        public void run() {
            counter.decrementAndGet();
        }
    }
    static class Increment extends Thread {
        public void run() {
            counter.incrementAndGet();
        }
    }
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            new Increment().start();
            new Decrement().start();
        }
        // It will not always be a 0 here
        // because it depends on threads schedule
        System.out.println(counter);
    }
}
