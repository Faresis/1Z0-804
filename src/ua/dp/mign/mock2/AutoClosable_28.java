package ua.dp.mign.mock2;

import java.util.Scanner;

class AutoClosable_28 {
    /*
     * close() method from AutoCloseable closes stream
     * and releases any resources associated with it.
     * If the stream is already closed, then invoking
     * this method has no effect.
     */
    public static void main(String[] args) {
        try (Scanner consoleScanner = new Scanner(System.in)) {
            consoleScanner.close();
            consoleScanner.close();
        }
    }
}
