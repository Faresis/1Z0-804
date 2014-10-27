package ua.dp.mign.wildcards.upper;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

class ModifyReadonly {
    /*
     * For the first slight nums collection looks like a read
     * only one. But it is not. We can capture actual wildcard
     * type through generics method and perform manipulations
     * on objects from the same collection (rearrangement etc.)
     * also it is possible to clear collection and remove objects
     * by using Iterator remove method.
     */
    private static void modify(List<? extends Number> nums) {
        replaceFirstAndLast(nums);
        nums.add(null);
    }

    /*
     * Helper method to capture actual type of wildcard collection.
     */
    private static <T> void replaceFirstAndLast(List<T> lst) {
        T tmp = lst.get(0);
        lst.set(0, lst.get(lst.size() - 1));
        lst.set(lst.size() - 1, tmp);
    }

    private static void print(Collection<?> col) {
        for(Object elem : col) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Double> nums = new ArrayList<Double>();
        nums.add(15.0);
        nums.add(7.0);
        nums.add(33.0);
        nums.add(1.0);

        print(nums);
        modify(nums);
        print(nums);
    }
}
