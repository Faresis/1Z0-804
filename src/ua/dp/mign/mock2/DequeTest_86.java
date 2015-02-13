package ua.dp.mign.mock2;

import java.util.Deque;
import java.util.ArrayDeque;

class DequeTest_86 {
    /*
     * In this example elements are added in the end
     * of the queue, so that they should be retrieved
     * first.
     * But then they are polled from the beginning of
     * the queue instead of its tail.
     * So the retrieval order is the same as they were
     * added because they are processed in reverse
     * direction.
     */
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<String>(2);
        deque.addFirst("one");
        deque.addFirst("two");
        deque.addFirst("three");
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
    }
}
