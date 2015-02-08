package ua.dp.mign.mock2;

import java.util.PriorityQueue;

class Task implements Comparable<Task> {
    int priority;
    public Task(int val) {
        priority = val;
    }
    public int compareTo(Task that) {
        if(this.priority == that.priority) 
            return 0;
        else if(this.priority > that.priority)
            return -1;
        else
            return 1;
    }
    public String toString() {
        return new Integer(priority).toString();
    }
}

class PQueueComparableTest_16 {
    public static void main(String[] args) {
        PriorityQueue<Task> tasks = new PriorityQueue<>();
        tasks.add(new Task(10));
        tasks.add(new Task(15));
        tasks.add(new Task(5));
        Task task;
        /*
         * Head of the PriorityQueue is always the least
         * element according to the specified ordering.
         * In the current scenario the highest priority
         * task will be indicated as a least element
         * and will be retrieved first.
         */
        while((task = tasks.poll()) != null) {
            System.out.print(task + " ");
        }
    }
}
