package ua.dp.mign.exceptions;

import java.io.IOException;

class Unreachable {
    /*
     * Even if exception is thrown from unreachable
     * code - compiler doesn't care. Such exception
     * still should be declared within throws clause.
     */
    public static void main(String[] args) {
        if (true) {
            throw new IllegalArgumentException();
        } else {
            throw new IOException();
        }
    }
}
