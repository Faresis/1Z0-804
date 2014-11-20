package ua.dp.mign.io.console;

import java.io.Console;

class Echo {
    public static void main(String[] args) {
        Console console = System.console();
        if(console == null) {
            System.err.println("Error grabbing console.");
            System.exit(-1);
        }
        String str;
        while((str = console.readLine()) != null) {
            System.out.println(str);
        }
    }
}
