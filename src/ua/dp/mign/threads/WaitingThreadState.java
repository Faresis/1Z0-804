package ua.dp.mign.threads;

class InfiniteWaitThread extends Thread {
    static boolean okeyToRun = false;
    synchronized public void run() {
        while(!okeyToRun) {
            try {
                wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}

class WaitingThreadState {
    public static void main(String[] args) {
        Thread t = new InfiniteWaitThread();
        t.start();
        System.out.println(t.getName() + ": I'm in state " + t.getState());
    }
}
