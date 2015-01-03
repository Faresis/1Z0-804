package ua.dp.mign.exceptions;

class Finally {
    public static void main(String[] args) {
        try {
            System.out.println("Trying...");
            throw new Exception();
        } catch (Exception e) {
            System.err.println("Exception... Exiting...");
            System.exit(-1);
        }
        /*
         * if System.exit will be called than finally block
         * will not be executed.
         */
        finally {
            System.out.println("Finalizing...");
        }
    }
}
