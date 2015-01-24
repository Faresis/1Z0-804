package ua.dp.mign.concurrent.executors;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class SumOfNUsingForkJoin {
    private static long N = 1000_000L;
    private static final int NUM_OF_THREADS = 10;

    static class RecursiveSumOfN extends RecursiveTask<Long> {
        private long from, to, total;
        private int threshold;

        public RecursiveSumOfN(long from, long to, long total, int threshold) {
            this.from = from;
            this.to = to;
            this.total = total;
            this.threshold = threshold;
        }

        public Long compute() {
            if( (to - from) <= total/threshold) {
                long localSum = 0;
                for(long i = from; i <= to; i++) {
                    localSum += i;
                }
                System.out.printf("\t Summing of value range from %d to %d is %d %n", from, to, localSum);
                return localSum;
            } else {
                long mid = (from + to) / 2;
                RecursiveSumOfN first = new RecursiveSumOfN(from, mid, total, threshold);
                first.fork();
                RecursiveSumOfN second = new RecursiveSumOfN(mid + 1, to, total, threshold);
                long resultSecond = second.compute();
                return first.join() + resultSecond;
            }
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(NUM_OF_THREADS);
        long computedSum = pool.invoke(new RecursiveSumOfN(0, N, N, NUM_OF_THREADS));
        long formulaSum = (N * (N + 1)) / 2;
        System.out.printf("Sum for range 1..%d; computed sum = %d, formula sum = %d %n", N, computedSum, formulaSum);
    }
}
