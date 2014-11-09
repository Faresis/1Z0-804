package ua.dp.mign.strings;

import java.util.Arrays;

class ValueOf {
    public static void main(String[] args) {
        System.out.println(String.valueOf(5));
        System.out.println(String.valueOf(5.83));
        System.out.println(String.valueOf(new Object()));
        System.out.println(String.valueOf(new Integer(1)));
        System.out.println(String.valueOf(new int[] { 1, 2, 3 }));
        System.out.println(String.valueOf(Arrays.asList(1, 2, 3 )));
    }
}
