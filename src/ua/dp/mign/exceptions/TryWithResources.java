package ua.dp.mign.exceptions;

class Resource implements AutoCloseable {
    Resource() {
        /*
         * In case when exception is thrown during
         * resource allocation, it will be handled
         * in the inner catch block.
         * No further code will be executed.
         */
        //throw new RuntimeException("From constructor");
    }

    public void someMethod() {
        /*
         * In case of try-with-resources block, exceptions
         * that are thrown from within the try block
         * have a top priority and other exceptions
         * that are thrown during resources cleanup
         * from within implicit finally block are suppressed
         * and added to the inner collection of the exceptions
         * from the try block.
         */
        throw new RuntimeException("From someMethod");
    }

    public void close() {
        /*
         * In case when exception is thrown during
         * resource cleanup, it will be handled
         * in the inner catch block.
         * In case when some exception was already thrown
         * from within the try block than this exception
         * will be suppressed and added to the inner
         * collection of the exception from the try
         * block.
         */
        throw new IllegalArgumentException("From close");
    }
}

class TryWithResources {
    public static void main(String[] args) {
        try (Resource res = new Resource()) {
            res.someMethod();
        } catch (Exception ex) {
            System.out.println("Inner catch.");
            ex.printStackTrace();
        }
    }
}
