package ua.dp.mign.threads;

class AsyncThread extends Thread {
    public void run() {
        System.out.println("Starting the thread " + getName());
        for(int i=0; i<3; i++) {
            System.out.printf("In thread %s iteration %d%n",
                              getName(), i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        AsyncThread thr1 = new AsyncThread();
        AsyncThread thr2 = new AsyncThread();
        thr1.start();
        thr2.start();
    }
}
