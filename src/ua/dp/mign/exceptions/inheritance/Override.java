package ua.dp.mign.exceptions.inheritance;

import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;

interface Reader {
    int read() throws IOException;
}

class Override implements Reader {
    /*
     * When overriding method that throws an exception
     * overriding method can declare throws clause with
     * the same exception, more specific exception or
     * no exception at all.
     * Even few more specific exceptions can be declared
     * instead of one more general.
     * All examples below are correct.
     */
    public int read() throws FileNotFoundException, EOFException { return 1; }
    //public int read() throws FileNotFoundException { return 1; }
    //public int read() { return 1; }
}
