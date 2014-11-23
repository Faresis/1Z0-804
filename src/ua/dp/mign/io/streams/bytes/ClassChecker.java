package ua.dp.mign.io.streams.bytes;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

class ClassChecker {
    public static void main(String[] args) {
        String fileName;
        if(args.length == 1) {
            fileName = args[0];
        } else {
            Console console = System.console();
            if(console == null) {
                System.err.println("Please specify file name to process.");
                System.exit(-1);
            }
            fileName = console.readLine("Enter file name: ");
        }
        byte[] template = { (byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBE };
        try(FileInputStream inputFile = new FileInputStream(fileName)) {
            byte[] firstBytes = new byte[4];
            if(inputFile.read(firstBytes) != -1) {
                if(Arrays.equals(template, firstBytes)) {
                    System.out.println("It is a class file.");
                } else {
                    System.out.println("It is NOT a class file.");
                }
            } else {
                System.err.println("Error reading of first four bytes.");
                System.exit(-1);
            }
        } catch (FileNotFoundException fnfe) {
            System.err.printf("File %s can't be found.", fileName);
            System.exit(-1);
        } catch (IOException ioe) {
            System.err.printf("Error during processing file %s.", fileName);
            System.exit(-1);
        }
    }
}
