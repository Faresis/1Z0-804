package ua.dp.mign.mock1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * This example shows that ReentrantLock can be
 * acquired multiple times and it holds internal
 * counter. Lock will be released when number of
 * unlock calls will be equal to the number of calls
 * to the lock method.
 * If unlock method will be called when lock is not
 * acquired by the current thread it will result
 * in IllegalMonitorStateException.
 */
class ReentrantLock_86 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        try {
            System.out.println("Lock 1");
            lock.lock();
            System.out.println("Critical section 1");
            System.out.println("Lock 2");
            lock.lock();
            System.out.println("Critical section 2");
        } finally {
            lock.unlock();
            System.out.println("Unlock 2");
            lock.unlock();
            System.out.println("Unlock 1");
        }
    }
}
