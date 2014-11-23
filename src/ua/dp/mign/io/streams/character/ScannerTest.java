package ua.dp.mign.io.streams.character;

import java.io.Console;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

class ScannerTest {
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
        Set<String> words = new TreeSet<>();
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            scanner.useDelimiter("\\W");
            while(scanner.hasNext()) {
                String word = scanner.next();
                if(!"".equals(word)) {
                    words.add(word.toLowerCase());
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.err.printf("File %s can't be found.", fileName);
        } 

        for(String word : words) {
            System.out.printf("%s \t", word);
        }
    }
}
