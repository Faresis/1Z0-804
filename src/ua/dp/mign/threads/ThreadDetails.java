package ua.dp.mign.threads;

class ThreadDetails {
    public static void main(String[] args) {
        Thread t = new Thread();
        System.out.printf("Default thread is: %s.%n", t);
        t.setName("SimpleThread");
        t.setPriority(9);
        System.out.printf("Modified thread is: %s.%n", t);
    }
}
