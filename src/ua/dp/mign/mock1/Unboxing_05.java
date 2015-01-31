package ua.dp.mign.mock1;

class Unboxing_05 {
    /*
     * This code will result in NullPointerException
     * since wrapper types can be used instead of 
     * primitive ones. In this scenario unboxing takes
     * place with the reference pointing to null.
     * As a result exception will be thrown.
     */
    public static void main(String[] args) {
        Boolean b = null;
        System.out.println(b ? true : false);
    }
}
