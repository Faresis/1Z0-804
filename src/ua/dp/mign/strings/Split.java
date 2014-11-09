package ua.dp.mign.strings;

import java.util.Arrays;

class Split {
    public static void main(String[] args) {
        String string = "boo:and:foo";
        String string2 = "boo and foo";
        String string3 = "boo1and4foo";
        System.out.println(Arrays.asList(string.split("\\W")));
        System.out.println(Arrays.asList(string2.split("\\s")));
        System.out.println(Arrays.asList(string3.split("\\d")));
        System.out.println(Arrays.asList(string.split("c")));
        System.out.println(Arrays.asList(string.split("\\W", 2)));
    }
}
