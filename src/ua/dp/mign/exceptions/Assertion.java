package ua.dp.mign.exceptions;

class Assertion {
    public static void main(String[] args) {
        int i = Integer.MIN_VALUE;
        if(i < 0) {
            // if negative convert to positive
            i = -i;
        }
        System.out.println("The value of i is: " + i);
        assert (i >= 0) : "i can't be less then 0";
    }
}
