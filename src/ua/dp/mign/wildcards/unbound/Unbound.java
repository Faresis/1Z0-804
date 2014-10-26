package ua.dp.mign.wildcards.unbound;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Collection;
import java.util.Arrays;

class Unbound {
    /*
     * Unbound wildcards should be used in cases when
     * properties exposed by the Object type is enough 
     * for method implementation or when methods of
     * generic type used in current implementation
     * does not depend on the type parameter.
     */
    static void print(Collection<?> col) {
        for(Object elem : col) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        Set<String> fltSet = new LinkedHashSet<String>();
        fltSet.add("Hello");
        fltSet.add("World");
        fltSet.add("!");

        print(intList);
        print(fltSet);
    }
}
