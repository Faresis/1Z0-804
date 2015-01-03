package ua.dp.mign.exceptions;

class Resource implements AutoCloseable {
    Resource() {
        //throw new RuntimeException("From constructor");
    }

    public void someMethod() {
        throw new RuntimeException("From someMethod");
    }

    public void close() {
        throw new IllegalArgumentException("From close");
    }
}

class TryCatchFinally {
    /*
     * With old fashion try-finally approach
     * exceptions that are thrown from within
     * the try block will be always overridden/hidden
     * by the exceptions from the finally block
     * if no additional efforts provided.
     * This problem is solved in try-with-resources
     * approach with concept of suppressed exceptions.
     * Exceptions from the try block have a higher
     * priority while exceptions from the finally
     * block are processed as suppressed ones if any.
     */
    private static void processResource() {
        Resource res = null;
        try {
            res = new Resource();
            res.someMethod();
        }
        finally {
            if (res != null) {
                res.close();
            }
        }
    }
    public static void main(String[] args) {
        try {
            processResource();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
