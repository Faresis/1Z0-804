package ua.dp.mign.generics.runtime;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Casting {
    public static void main(String[] args) {
        List<Object> objectList = new ArrayList<>();
        List<Integer> li = new LinkedList<>();
        List<?> unboundList = new ArrayList<String>();
        List<? extends Number> listExNumber = new ArrayList<>();
        

        /*
         * Both upcasts and downcasts are denied for generic
         * type parameters. Thus following lines will cause
         * compilation error.
         */
        //List<String> stringList = (List<String>)objectList;
        //List<Number> numbersList = (List<Number>)li;

        /*
         * Using casts with generic type itself is allowed.
         * Following will compile but will result in a runtime
         * exception.
         */
        //ArrayList<Integer> arrayFromLinked = (ArrayList<Integer>)li;

        /*
         * But for wildcards it is allowed.
         */
        List<String> stringList = (List<String>)unboundList;
        List<Number> numList = (List<Number>)unboundList;

        // Inconvertible data types will be handled during compile time.
        //List<String> lss = (List<String>)listExNumber;
        //List<Character> charList = (List<Character>)listExNumber;
        List<Number> lnn = (List<Number>)listExNumber;
        List<Integer> lin = (List<Integer>)listExNumber;
    }
}
