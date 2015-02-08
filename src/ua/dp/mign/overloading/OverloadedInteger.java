package ua.dp.mign.overloading;

import static java.lang.System.out;

class OverloadedInteger {
    /*
     * #1 exact match
     */
    public static void aMethod(Integer val) {
        out.println("Integer");
    }
    /*
     * #2
     */
    public static void aMethod(Number val) {
        out.println("Number");
    }
    /*
     * #3
     */
    public static void aMethod(Object val) {
        out.println("Object");
    }
    /*
     * #4
     */
    public static void aMethod(int val) {
        out.println("int");
    }
    /*
     * #5
     */
    public static void aMethod(long val) {
        out.println("long");
    }
    /*
     * #6
     */
    public static void aMethod(double val) {
        out.println("double");
    }
    /*
     * #7
     */
    public static void aMethod(Integer... val) {
        out.println("Integer...");
    }
    public static void main(String args[]) {
        Integer i = 9;
        aMethod(i);
    }
}
