package ua.dp.mign.nio.files;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

class AttributesByType {
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
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("File size: " + attributes.size());
            System.out.println("Is directory: " + attributes.isDirectory());
            System.out.println("Is regular file: " + attributes.isRegularFile());
            System.out.println("Is symbolic link: " + attributes.isSymbolicLink());
            System.out.println("Last access time: " + attributes.lastAccessTime());
            System.out.println("Last modification time: " + attributes.lastModifiedTime());
            System.out.println("Creation time: " + attributes.creationTime());
        } catch (IOException ioe) {
            System.err.printf("Error during processing file %s: %s.%n", path, ioe.getMessage());
        }
    }
}
