package ua.dp.mign.exceptions;

class ExceptionA extends Exception {}
class ExceptionB extends ExceptionA {}
class ExceptionX extends Exception {}

class MultiCatch {
    /*
     * throws clause can contain exceptions that are not
     * actually thrown from within a method. Compiler
     * doesn't care.
     */
    private static void foo() throws ExceptionA, ExceptionB, ExceptionX {}
    public static void main(String[] args) {
        try {
            foo();
        }
        // related classes can't be placed in a multi-catch block
        /*
        catch (ExceptionA | ExceptionB exAB) {
            exAB.printStackTrace();
        }
        */
        catch (ExceptionB exAB) {
            exAB.printStackTrace();
        }
        catch (ExceptionA | ExceptionX exx) {
            exx.printStackTrace();
        }
    }
}
