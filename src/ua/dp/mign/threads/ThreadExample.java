package ua.dp.mign.threads;

class ThreadExample extends Thread {
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.printf("In run method; thread name is: %s.%n", getName());
    }

    public static void main(String[] args) {
        Thread myThread = new ThreadExample();
        myThread.start();
        System.out.printf("In main method; thread name is: %s.%n",
                          Thread.currentThread().getName());
    }
}
