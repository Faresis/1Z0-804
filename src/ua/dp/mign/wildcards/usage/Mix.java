package ua.dp.mign.wildcards.usage;

import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Stack;

class Mix {
    /*
     * Usage of wildcards and generics can be mixed when relation between
     * arguments or arguments and return value types exists.
     */
    static <T> void copy(Collection<? extends T> src, Collection<? super T> dst) {
        for(T obj : src) {
            dst.add(obj);
        }
    }

    static void print(Collection<?> col) {
        for(Object elem : col) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Double> dblList = Arrays.asList(2.0, 3.5, 4.0, 4.5);
        Set<Integer> intSet = new LinkedHashSet<>();
        intSet.add(1);
        intSet.add(5);
        intSet.add(7);
        intSet.add(8);
        Stack<Object> nums = new Stack<>();

        copy(dblList, nums);
        copy(intSet, nums);

        print(nums);
    }
}
