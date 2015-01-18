package ua.dp.mign.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class RunningRaceStarter {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch counter = new CountDownLatch(5);

        new Runner(counter, "Carl");
        new Runner(counter, "Joe");
        new Runner(counter, "Jack");

        System.out.println("Starting the countdown");
        do {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            System.out.println(counter.getCount());
            if(counter.getCount() == 1) {
                System.out.println("Start");
            }
            counter.countDown();
        } while(counter.getCount() > 0);
    }
}

class Runner extends Thread {
    private CountDownLatch timer;

    public Runner(CountDownLatch cdl, String name) {
        timer = cdl;
        this.setName(name);
        System.out.printf("%s ready and waiting for the countdown to start.%n", getName());
        start();
    }

    public void run() {
        try {
            timer.await();
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.printf("%s started running.%n", getName());
    }
}
