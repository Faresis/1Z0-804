package ua.dp.mign.generics.methods;

import java.util.*;

class Util {
    public static <T> void fill(List<T> list, T val) {
        for(int i = 0; i < list.size(); i++)
            list.set(i, val);
    }
}

class GenericMethod {
    public static void main(String[] args) {
        List<Number> numList = new ArrayList<Number>();
        numList.add(new Integer(2));
        numList.add(new Float(4));

        System.out.println("Before fill: " + numList);

        /*
         * If method type argument is defined explicitly
         * it should be placed before a method name in
         * angle brackets.
         */
        Util.<Number>fill(numList, new Double(8));
        /*
         * Also it can be omitted in case when compiler
         * can infer it from the passed arguments.
         */
        Util.fill(numList, new Double(8));

        System.out.println("After fill: " + numList);
    }
}
