package ua.dp.mign.threads.waitnotify;

class Waiter extends Thread {
    public void getCoffee() {
        synchronized(CoffeeMachine.lock) {
            while(CoffeeMachine.coffeeMade == null) {
                try {
                    System.out.println("Waiter: Will get orders till coffee machine notifies me");
                    CoffeeMachine.lock.wait();
                } catch(InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
            System.out.println("Waiter: Delivering " + CoffeeMachine.coffeeMade);
            CoffeeMachine.coffeeMade = null;
            CoffeeMachine.lock.notifyAll();
            System.out.println("Waiter. Notifying coffee machine to make another one");
        }
    }

    public void run() {
        while(true) {
            getCoffee();
        }
    }
}
