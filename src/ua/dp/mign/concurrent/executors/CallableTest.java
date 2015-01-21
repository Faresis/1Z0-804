package ua.dp.mign.concurrent.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

class Factorial implements Callable<Long> {
    private long n;
    public Factorial(long n) {
        this.n = n;
    }
    public Long call() throws Exception {
        if(n <= 0) {
            throw new IllegalArgumentException("N should be greater than 0");
        }
        long fact = 1;
        for(long longVal = 1;  longVal <= n; longVal++) {
            fact *= longVal;
        }
        return fact;
    }
}

class CallableTest {
    public static void main(String[] args) throws Exception {
        long N = 20;
        Callable<Long> task = new Factorial(N);
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Long> future = es.submit(task);
        System.out.printf("factorial of %d is %d", N, future.get());
        es.shutdown();
    }
}
