package ua.dp.mign.threads;

class RunnableExample implements Runnable {
    public void run() {
        System.out.printf("In run method; thread name is: %s.%n",
                          Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        Thread myThread = new Thread(new RunnableExample());
        myThread.start();
        System.out.printf("In main method; thread name is: %s.%n",
                          Thread.currentThread().getName());
    }
}
