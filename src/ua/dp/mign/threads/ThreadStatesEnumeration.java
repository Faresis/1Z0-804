package ua.dp.mign.threads;

class ThreadStatesEnumeration {
    public static void main(String[] args) {
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }
    }
}
