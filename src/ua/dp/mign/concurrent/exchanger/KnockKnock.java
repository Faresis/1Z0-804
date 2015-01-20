package ua.dp.mign.concurrent.exchanger;

import java.util.concurrent.Exchanger;

class DukeThread extends Thread {
    private Exchanger<String> sillyTalk;

    public DukeThread(Exchanger<String> sillyTalk) {
        this.sillyTalk = sillyTalk;
    }

    public void run() {
        String reply = null;
        try {
            reply = sillyTalk.exchange("Knock knock!");
            System.out.println("CoffeeShop: " + reply);

            reply = sillyTalk.exchange("Duke");
            System.out.println("CoffeeShop: " + reply);

            reply = sillyTalk.exchange("The one who was born in this coffee shop!");
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}

class CoffeeShopThread extends Thread {
    private Exchanger<String> sillyTalk;

    public CoffeeShopThread(Exchanger<String> sillyTalk) {
        this.sillyTalk = sillyTalk;
    }

    public void run() {
        String reply = null;
        try {
            reply = sillyTalk.exchange("Who's there?");
            System.out.println("Duke: " + reply);

            reply = sillyTalk.exchange("Duke who?");
            System.out.println("Duke: " + reply);

            reply = sillyTalk.exchange("");
            System.out.println("Duke: " + reply);
        } catch(InterruptedException ie)  {
            ie.printStackTrace();
        }
    }
}

public class KnockKnock {
    public static void main(String[] args) {
        Exchanger<String> sillyTalk = new Exchanger<>();
        new  CoffeeShopThread(sillyTalk).start();
        new  DukeThread(sillyTalk).start();
    }
}
