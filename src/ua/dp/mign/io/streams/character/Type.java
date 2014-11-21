package ua.dp.mign.io.streams.character;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Console;

class Type {
    public static void main(String[] args) {
        String[] files;
        if(args.length == 0) {
            Console console = System.console();
            if(console == null) {
                System.err.println("Pass file names as an arguments.");
                System.exit(-1);
            }
            String fileNames = console.readLine("Enter file names: ");
            files = fileNames.split("\\s");
        } else {
            files = args;
        }

        for(String file : files) {
            try (FileReader inputFile = new FileReader(file)) {
                System.out.printf("%s: %n", file); 
                int ch;
                while((ch = inputFile.read()) != -1) {
                    System.out.print((char)ch);
                }
                System.out.println();
            } catch (FileNotFoundException fnfe) {
                System.err.printf("Can't open file %s", file);
            } catch (IOException ioe) {
                System.err.printf("Error while processing file %s", file);
            }
        }
    }
}
