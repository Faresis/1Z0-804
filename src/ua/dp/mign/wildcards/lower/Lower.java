package ua.dp.mign.wildcards.lower;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.LinkedList;

class Lower {
    /*
     * Lower bound wildcards allow us to insert elements to the
     * collection. Because parent type is always allowed to handle
     * a reference to its child.
     */
    static void addNumbers(Collection<? super Integer> nums) {
        for(int i = 0; i < 10; i++) {
            nums.add(i);
        }
    }

    static void print(Collection<?> col) {
        for(Object elem : col) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        Set<Object> objSet = new LinkedHashSet<>();
        Collection<Number> nums = new LinkedList<>(); 

        addNumbers(intList);
        addNumbers(objSet);
        addNumbers(nums);

        print(intList);
        print(objSet);
        print(nums);
    }
}
