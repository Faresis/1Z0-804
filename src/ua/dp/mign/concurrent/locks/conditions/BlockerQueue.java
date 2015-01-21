package ua.dp.mign.concurrent.locks.conditions;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class BlockerQueue {
    private int size = 0;
    private Object elements[];
    private int currPointer = 0;
    private Lock internalLock = new ReentrantLock();
    private Condition empty = internalLock.newCondition();
    private Condition full = internalLock.newCondition();

    public BlockerQueue(int size) {
        this.size = size;
        elements = new Object[size];
    }

    public Object remove() {
        Object element = null;
        internalLock.lock();
        try {
            while(currPointer == 0) {
                empty.await();
                System.out.println("In remove. Got notification that element is inserted");
            }
            element = elements[--currPointer];
            System.out.println("In remove. Removed element: " + element);

            full.signalAll();
            System.out.println("In remove. Signaled that there is space for insertion");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            internalLock.unlock();
        }
        return element;
    }

    public void insert(Object element) {
        internalLock.lock();
        try {
            while(currPointer == size) {
                full.await();
                System.out.println("In insert. Got notification that remove got called. So proceeding to insert the element");
            }
            elements[currPointer++] = element;
            System.out.println("In insert. Inserted element " + element);

            empty.signalAll();
            System.out.println("In insert. Notified that queue is not empty");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            internalLock.unlock();
        }
    }

    public static void main(String[] args) {
        final BlockerQueue blockerQueue = new BlockerQueue(2);
        new Thread() {
            public void run() {
                System.out.println("Thread1: attempting to remove an item from the queue");
                Object o = blockerQueue.remove();
            }
        }.start();

        new Thread() {
            public void run() {
                System.out.println("Thread2: attempting to insert an item to the queue");
                blockerQueue.insert("one");
            }
        }.start();
    }
}
