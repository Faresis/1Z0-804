package ua.dp.mign.exceptions.inheritance;

import java.io.IOException;
import java.io.FileNotFoundException;
import javax.xml.bind.PropertyException;

interface ReaderLight {
    int read() throws IOException;
}

interface ReaderStrong {
    int read() throws FileNotFoundException;
}

interface ReaderStrange {
    int read() throws PropertyException;
}

/*
 * During implementation of the interfaces method read()
 * implementing method can't declare all exceptions thrown
 * by those interfaces. Because they have no shared subclass.
 * If we declare all available exceptions in the throws clause
 * we will broke exceptions constraint for all interfaces.
 * Because users of those interfaces are not ready to handle
 * such number of exceptions.
 * One of possible solutions is to not declare throws clause
 * in implementation at all.
 * Also if shared subclass for all exceptions be available
 * we will be able to use it in the throws clause as it will
 * be more specific declaration for all interfaces.
 */
class Merge implements ReaderLight, ReaderStrong, ReaderStrange {
    public int read() { return -1; }
}
