package ua.dp.mign.wildcards.usage;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;

class ExclusiveInclusive {
    public static void processStrings(List<? extends String> strings) {
        for(String str : strings) {
            System.out.println(str);
        }
    }

    public static void processNumbers(List<? super Integer> numbers) {
        for(int i = 0; i < 10; i++) {
            numbers.add(i);
        }
    }

    public static void print(Collection<?> col) {
        for(Object o : col) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    public static void main(String []args) {
        List<String> strings = Arrays.asList("one", "two", "three");
        List<Integer> integers = new ArrayList<Integer>();

        /*
         * List<String> is passed where List<? Extends String> was
         * expected. It means that extends bound is inclusive.
         */
        processStrings(strings);
        /*
         * List<Integer> is passed where List<? Super Integer> was
         * expected. It means that super bound is inclusive.
         */
        processNumbers(integers);
        print(integers);
    }
}
