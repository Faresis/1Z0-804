package ua.dp.mign.threads;

class Counter {
    public static long count = 0;
}

class UseCounter implements Runnable {
    /*
     * This method will be synchronized for all
     * instances of this class. And all threads
     * that are trying to use it with any instance of 
     * this class will be blocked while this method
     * in use.
     */
    public void increment() {
        synchronized(UseCounter.class) {
            Counter.count++;
            System.out.print(Counter.count + " ");
        }
    }
    public void run() {
        increment();
        increment();
        increment();
    }
}

class DataRaceClassFixed {
    public static void main(String[] args) {
        UseCounter c = new UseCounter();
        Thread t1 = new Thread(c);
        c = new UseCounter();
        Thread t2 = new Thread(c);
        c = new UseCounter();
        Thread t3 = new Thread(c);
        t1.start();
        t2.start();
        t3.start();
    }
}
