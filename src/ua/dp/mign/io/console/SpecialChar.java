package ua.dp.mign.io.console;

import java.io.Console;

class SpecialChar {
    public static void main(String[] args) {
        String scandString = "å, ä, and ö";
        System.out.println("Directly: " + scandString);

        Console console = System.console();
        console.format("Through console: %s", scandString);
    }
}
