package ua.dp.mign.exceptions;

class ExceptionA extends Exception {}
class ExceptionB extends Exception {}
class ExceptionC extends Exception {}

class PreciseRethrow {
    private static void foo() throws ExceptionA, ExceptionB {}
    private static void bar() throws ExceptionC {}

    /*
     * Since Java 7 it is enough to declare only those types of
     * checked exceptions in a throws clause that are actually
     * re-thrown. Compiler checks all possible checked exceptions
     * that can be thrown from a try block and only those types
     * should be declared, despite of which type is used in a catch
     * clause.
     */
    private static void test() throws ExceptionA, ExceptionB, ExceptionC {
        try {
            foo();
            bar();
        } catch (Exception e) {
            throw e;
        }
    }
} 
