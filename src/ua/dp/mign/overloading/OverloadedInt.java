package ua.dp.mign.overloading;

import static java.lang.System.out;

class OverloadedInt {
    /*
     * #1 exact match
     */
    public static void aMethod(int val) {
        out.println("int");
    }
    /*
     * #2 next primitive
     */
    public static void aMethod(long val) {
        out.println("long");
    }
    /*
     * #3 next primitive
     */
    public static void aMethod(double val) {
        out.println("double");
    }
    /*
     * #4
     */
    public static void aMethod(Integer val) {
        out.println("Integer");
    }
    /*
     * #5
     */
    public static void aMethod(Object val) {
        out.println("Object");
    }
    /*
     * #6
     */
    public static void aMethod(int... val) {
        out.println("int...");
    }
    public static void main(String args[]) {
        aMethod(9);
    }
}
