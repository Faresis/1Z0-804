package ua.dp.mign.threads;

class BasicThreadStates extends Thread {
    public static void main(String[] args) throws Exception {
        Thread t = new BasicThreadStates();
        System.out.println("Just after creating a thread;" +
                           "Thread state is: " + t.getState());
        t.start();
        System.out.println("Just after starting a thread;" +
                           "Thread state is: " + t.getState());
        t.join();
        System.out.println("Just after join on a thread;" +
                           "Thread state is: " + t.getState());

    }
}
