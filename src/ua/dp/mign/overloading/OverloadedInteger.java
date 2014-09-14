package ua.dp.mign.overloading;

import static java.lang.System.out;

class OverloadedInteger {
    public static void aMethod(Integer val) {
        out.println("Integer");
    }
    public static void aMethod(Number val) {
        out.println("Number");
    }
    public static void aMethod(Object val) {
        out.println("Object");
    }
    public static void aMethod(int val) {
        out.println("int");
    }
    public static void aMethod(long val) {
        out.println("long");
    }
    public static void aMethod(double val) {
        out.println("double");
    }
    public static void aMethod(Integer... val) {
        out.println("Integer...");
    }
    public static void main(String args[]) {
        Integer i = 9;
        aMethod(i);
    }
}
