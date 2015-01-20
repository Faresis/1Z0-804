package ua.dp.mign.concurrent.barrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

class MixedDoubleTennisGame extends Thread {
    public void run() {
        System.out.println("All four players ready, game starts \n Love all...");
    }
}

class Player extends Thread {
    CyclicBarrier waitPoint;
    public Player(CyclicBarrier barrier, String name) {
        this.waitPoint = barrier;
        this.setName(name);
        this.start();
    }

    public void run() {
        System.out.println("Player " + getName() + " is ready ");
        try {
            waitPoint.await();
        } catch(BrokenBarrierException | InterruptedException exception) {
            System.out.println("An exception occurred while waiting..." + exception);
        }
    }
}

public class CyclicBarrierTest {
    public static void main(String[] args) {
        System.out.println("Reserving tennis court.");
        System.out.println("As soon as four players arrive game will start.");
        CyclicBarrier barrier = new CyclicBarrier(4, new MixedDoubleTennisGame());
        new Player(barrier, "G I Joe");
        new Player(barrier, "Dora");
        new Player(barrier, "Tintin");
        new Player(barrier, "Barbie");
    }
}
