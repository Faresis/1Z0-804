package ua.dp.mign.threads;

class Counter {
    public static long count = 0;
}

class UseCounter implements Runnable {
    /*
     * This method will be synchronized per each
     * instance of this class since it is an 
     * instance method. So if there will be a few
     * threads and each will have its own UseCounter
     * instance they will not be blocked and can be
     * run in parallel.
     */
    public synchronized void increment() {
        Counter.count++;
        System.out.print(Counter.count + " ");
    }
    public void run() {
        increment();
        increment();
        increment();
    }
}

class DataRaceInstanceFixed {
    public static void main(String[] args) {
        UseCounter c = new UseCounter();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c);
        t1.start();
        t2.start();
        t3.start();
    }
}
