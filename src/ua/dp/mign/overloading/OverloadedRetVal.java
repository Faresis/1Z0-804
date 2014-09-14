package ua.dp.mign.overloading; 

import static java.lang.System.out;

class OverloadedRetVal {
    public static void aMethod(int val) {
        out.println("int.void");
    }
    public static long aMethod(long val) {
        out.println("long.long");
        return 12;
    }
    public static void main(String args[]) {
        long res = aMethod(0b111l);
        out.println(res);
    }
}
