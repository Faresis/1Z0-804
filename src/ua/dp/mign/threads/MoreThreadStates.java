package ua.dp.mign.threads;

class SleepyThread extends Thread {
    public void run() {
        synchronized(SleepyThread.class) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}

class MoreThreadStates {
    public static void main(String[] args) {
        Thread t1 = new SleepyThread();
        Thread t2 = new SleepyThread();
        t1.start();
        t2.start();
        System.out.println(t1.getName() + ": I'm in state " + t1.getState());
        System.out.println(t2.getName() + ": I'm in state " + t2.getState());
    }
}
