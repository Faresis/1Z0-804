package ua.dp.mign.generics.subtyping;

import java.util.*;

class Subtyping {
    public static void main(String[] args) {
        /*
         * This one will fail because generic type parameters
         * can't be subtyped.
         */
        //List<Number> intList = new ArrayList<Integer>();
        
        /*
         * This one will not fail because generic type itself
         * can be subtyped.
         */
        List<Number> numList = new LinkedList<Number>();
    }
}
