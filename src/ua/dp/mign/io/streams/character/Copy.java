package ua.dp.mign.io.streams.character;

import java.io.Console;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

class Copy {
    public static void main(String[] args) {
        String[] files;
        if(args.length == 2) {
            files = args;
        } else {
            Console console = System.console();
            if(console == null) {
                System.err.println("Please specify src and dst files.");
                System.exit(-1);
            }
            files = new String[2];
            files[0] = console.readLine("Enter src file name: ");
            files[1] = console.readLine("Enter dst file name: ");
        }

        String srcFile = files[0];
        String dstFile = files[1];

        try (BufferedReader inputFile = new BufferedReader(new FileReader(srcFile));
        BufferedWriter outputFile = new BufferedWriter(new FileWriter(dstFile))) {
            int ch;
            while((ch = inputFile.read()) != -1) {
                outputFile.write((char)ch);
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("File can't be found.");
        } catch (IOException ioe) {
            System.err.println("Error during file processing.");
        }
    }
}
