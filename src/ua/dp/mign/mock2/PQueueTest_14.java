package ua.dp.mign.mock2;

import java.util.PriorityQueue;

class PQueueTest_14 {
    public static void main(String[] args) {
        /*
         * PriorityQueue orders its elements according
         * to the natural ordering if no comparator is
         * specified during its construction.
         * Elements should be Comparable in such case.
         */
        PriorityQueue<Integer> values = new PriorityQueue<>();
        values.add(new Integer(10));
        values.add(new Integer(15));
        values.add(new Integer(5));
        Integer val;
        /*
         * poll() and remove() retrieve element from the
         * head of the query and remove it. Remove()
         * throws an exception if no element found. Poll()
         * return null in such case.
         * peek() and element() on the other hand retrieve
         * element from the head of the query but do NOT 
         * remove it. Element() throws an exception if no 
         * element found. Peek() return null in such case.
         */
        while((val = values.poll()) != null) {
            System.out.print(val + " ");
        }
    }
}
