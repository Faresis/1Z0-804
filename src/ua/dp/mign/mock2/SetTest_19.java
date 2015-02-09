package ua.dp.mign.mock2;

import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

class SetTest_19 {
    public static void main(String[] args) {
        List list = Arrays.asList(10, 5, 10, 20);
        // list holds elements order
        System.out.println(list);
        // hash set is unordered but only unique elements are stored
        System.out.println(new HashSet(list));
        // tree set unique elements + natural ordering
        System.out.println(new TreeSet(list));
        // concurrent skip list set unique elements + natural ordering + concurrency
        System.out.println(new ConcurrentSkipListSet(list));
    }
}
