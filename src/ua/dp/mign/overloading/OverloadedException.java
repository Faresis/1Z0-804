package ua.dp.mign.overloading; 

import java.io.IOException;
import static java.lang.System.out;

class OverloadedException {
    public static void aMethod(int val) throws Exception {
        out.println("int.Exception");
    }
    public static void aMethod(int val) throws IOException {
        out.println("int.ArgumentException");
    }
    public static void main(String args[]) {
        aMethod(9);
    }
}
