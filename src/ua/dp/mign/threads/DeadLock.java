package ua.dp.mign.threads;

class Balls {
    public static long balls = 0;
}

class Runs {
    public static long runs = 0;
}

class Counter implements Runnable {
    public void IncrementBallAfterRun() {
        synchronized(Runs.class) {
            synchronized(Balls.class) {
                Runs.runs++;
                Balls.balls++;
            }
        }
    }
    public void IncrementRunAfterBall() {
        synchronized(Balls.class) {
            synchronized(Runs.class) {
                Balls.balls++;
                Runs.runs++;
            }
        }
    }
    public void run() {
        IncrementBallAfterRun();
        IncrementRunAfterBall();
    }
}

class DeadLock {
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
        System.out.println("Waiting for threads to complete execution...");
        t1.join();
        t2.join();
        System.out.println("Done.");
    }
}
