package ua.dp.mign.nio.files;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

class AttributesByName {
    public static void main(String args[]) {
        String fileName;
        if (args.length != 1) {
            Console console = System.console();
            fileName = console.readLine("Enter file name: ");
            if (fileName == null || fileName.isEmpty()) {
                System.err.println("Please specify file name.");
                System.exit(-1);
            }
        } else {
            fileName = args[0];
        }

        Path path = Paths.get(fileName);
        try {
            Object attr = Files.getAttribute(path, "creationTime");
            System.out.printf("Creation time: %s%n", attr);
            attr = Files.getAttribute(path, "lastModifiedTime");
            System.out.printf("Last modification time: %s%n", attr);
            attr = Files.getAttribute(path, "size");
            System.out.printf("Size: %s%n", attr);
            attr = Files.getAttribute(path, "isDirectory");
            System.out.printf("Is directory: %s%n", attr);
        } catch (IOException ioe) {
            System.err.printf("Error during processing file %s: %s.%n", path, ioe.getMessage());
        }
    }
}
