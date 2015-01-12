package ua.dp.mign.threads;

class Countdown extends Thread {
    private String[] timerStr = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

    public void run() {
        for(int i = 9; i >= 0; i--) {
            try {
                System.out.println(timerStr[i]);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Countdown ctd = new Countdown();
        System.out.println("Starting 10 seconds countdown...");
        ctd.start();
        try {
            ctd.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Boom!!!");
    }
}
