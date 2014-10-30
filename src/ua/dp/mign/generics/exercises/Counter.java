package ua.dp.mign.generics.exercises;

import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

interface Evaluator<T> {
    boolean evaluate(T object);
}

class OddNumbersEvaluator implements Evaluator<Number> {
    public boolean evaluate(Number num) {
        return num.doubleValue() % 2 == 1;
    }
}

class CollectionCounter {
    public static <E> long count(Collection<E> collection, Evaluator<? super E> evaluator) {
        long counter = 0;
        for(E element : collection) {
            if(evaluator.evaluate(element)) {
                counter++;
            }
        }
        return counter;
    }
}

/*
 * Write a generic method to count the number of elements in a collection
 * that have a specific property (for example, odd integers, prime numbers,
 * palindromes).
 * With provided implementation CollectionCounter can count elements of any
 * type in any collection with supplied evaluator implementation which will
 * be responsible for evaluating if element should be count or not.
 */
class Counter {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6);
        Set<Double> doubles = new HashSet<Double>();
        doubles.addAll(Arrays.asList(1.0, 11.0, 21.0, 2.0, 44.0, 45.0, 1.0, 45.0));

        System.out.println("Odd integers: " + CollectionCounter.count(integers,  new OddNumbersEvaluator()));
        System.out.println("Odd doubles: " + CollectionCounter.count(doubles,  new OddNumbersEvaluator()));
    }
}
