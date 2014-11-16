package ua.dp.mign.strings.format;

import java.util.Date;

class Formatting {
    public static void main(String[] args) {
        // char data
        System.out.printf("char: %c", 33);
        System.out.println();

        // boolean data
        System.out.printf("boolean: %-10b word", 33);
        System.out.println();

        // floating point in scientific format
        System.out.printf("scientific: %+e", -33.0);
        System.out.println();

        // floating point
        System.out.printf("floating: %15.4f", 33.486731);
        System.out.println();

        // floating point
        System.out.printf("floating: % .2f", 33.892);
        System.out.println();

        // floating point
        System.out.printf("floating: %(f", -33.0);
        System.out.println();

        // floating point
        System.out.printf("floating: %+f", -33.0);
        System.out.println();
        
        // floating point
        System.out.printf("floating: %+f", 33.0);
        System.out.println();

        // hash code
        System.out.printf("hash: %h", 33.0);
        System.out.println();
        
        // octal
        System.out.printf("octal: %010o", 33);
        System.out.println();

        // hex
        System.out.printf("hex: %#x", 33);
        System.out.println();

        // string
        System.out.printf("string: %5.7s", "some string");
        System.out.println();

        // empty format string
        System.out.printf("", "some string");
        System.out.println();

        // date time
        System.out.printf("date time: %1$tD %1$tT", new Date());
        System.out.println();
    }
}
