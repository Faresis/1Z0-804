package ua.dp.mign.generics.runtime;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Instanceof {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new LinkedList<>();

        checkType(strings);
        checkType(integers);
    }

    /*
     * Usage of instanceof with generics is allowed only if
     * unbounded wildcard is used for comparison.
     */
    public static <E> void checkType(List<E> list) {
        /*
         * Instanceof can't be checked with generic type parameter.
         * Only wildcards are allowed. This will cause compilation
         * error.
         */
        /*
        if(list instanceof List<String>) {
            System.out.println("It is a strings list.");
        }
        */
        if(list instanceof ArrayList<?>) {
            System.out.println("It is an array list.");
        }
        else if(list instanceof LinkedList<?>) {
            System.out.println("It is a linked list.");
        }
        else {
            System.out.println("It is an undefined list.");
        }
    }
}
