package ua.dp.mign.overloading;

import static java.lang.System.out;

class OverloadedAmbiguous {
    public static void aMethod(long val1, int val2, int val3) {
        out.println("long, int, int");
    }
    public static void aMethod(int val1, long val2, int val3) {
        out.println("int, long, int");
    }
    public static void aMethod(int val1, int val2, long val3) {
        out.println("int, int, long");
    }
    public static void aMethod(int val1, long val2, long val3) {
        out.println("int, long, long");
    }
    public static void aMethod(int val1, int val2, int val3) {
        out.println("int, int, int");
    }
    public static void aMethod(int... val1) {
        out.println("int...");
    }
    public static void main(String args[]) {
        aMethod(9,10,11);
    }
}
