package ua.dp.mign.mock1;

class RuntimeException_55 {
    /*
     * Here is a possibility of NumberFormatException
     * to be thrown. But it should not be declared in
     * the throws clause because it is a runtime exception.
     */
    public static void main(String[] args) {
        String two = "2";
        System.out.println("1 + 2 + 3 + 4 = " + 1 + Integer.parseInt(two) + 3 + 4);
    }
}
