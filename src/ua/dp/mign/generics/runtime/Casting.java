package ua.dp.mign.generics.runtime;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Casting {
    public static void main(String[] args) {
        List<Object> objectList = new ArrayList<>();
        List<Integer> li = new LinkedList<>();
        List<?> lu = new ArrayList<String>();

        /*
         * Both upcasts and downcasts are denied for generic
         * type parameters. Thus following lines will cause
         * compilation error.
         */
        //List<String> stringList = (List<String>)objectList;
        //List<Number> ln = (List<Number>)li;

        /*
         * But for unbounded wildcards it is allowed.
         */
        List<String> ls = (List<String>)lu;

        /*
         * Using casts with generic type itself is allowed.
         */
        ArrayList<Integer> ali = (ArrayList<Integer>)li;
        li = ali;
    }
}
