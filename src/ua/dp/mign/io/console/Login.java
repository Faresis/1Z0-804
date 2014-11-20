package ua.dp.mign.io.console;

import java.io.Console;
import java.util.Arrays;

class Login {
    public static void main(String[] args) {
        Console console = System.console();
        if(console == null) {
            System.err.println("Console can't be grabbed.");
            System.exit(-1);
        }

        String login = console.readLine("Login: ");
        char[] password = console.readPassword("Password: ");
        if("admin".equals(login) && 
            Arrays.equals(password, new char[] {'a', 'd', 'm', 'i', 'n'})) {
            console.printf("Login successful.");
        }
        else {
            console.printf("Wrong login or password. Please try again.");
        }
        Arrays.fill(password, ' ');
    }
}
