package ua.dp.mign.concurrent.executors;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CancellationException;

class SumOfN {
    private static long N = 1_000_000L;
    private static long calculatedSum = 0;
    private static final int NUM_OF_THREADS = 10;

    static class SumCalc implements Callable<Long> {
        private long from, to, localSum = 0;

        public SumCalc(long from, long to) {
            this.from = from;
            this.to = to;
        }

        public Long call() {
            for(long i = from; i <= to; i++) {
                localSum += i;
            }
            return localSum;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_OF_THREADS);
        List<Future<Long>> summationTasks = new ArrayList<>();
        long countPerTask = N/NUM_OF_THREADS;
        for(int i = 0; i < NUM_OF_THREADS; i++) {
            long fromRange = (countPerTask * i) + 1;
            long toRange = countPerTask * (i + 1);
            System.out.printf("Creating thread for summing in range %d to %d %n", fromRange, toRange);
            Callable<Long> summationTask = new SumCalc(fromRange, toRange);
            Future<Long> result = executorService.submit(summationTask);
            summationTasks.add(result);
        }

        for(Future<Long> partialSum : summationTasks) {
            try {
                calculatedSum += partialSum.get();
            } catch(CancellationException | ExecutionException
                    | InterruptedException exception) {
                exception.printStackTrace();
                System.exit(-1);
            }
        }

        long formulaSum = (N * (N + 1)) / 2;
        System.out.printf("Sum by threads = %d, sum using formula = %d %n",
                          calculatedSum, formulaSum);
        executorService.shutdown();
    }
}
