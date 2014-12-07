package ua.dp.mign.nio.files;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

class Move {
    public static void main(String args[]) {
        String fileName1;
        String fileName2;
        if (args.length != 2) {
            Console console = System.console();
            fileName1 = console.readLine("Enter first file name: ");
            if (fileName1 == null || fileName1.isEmpty()) {
                System.err.println("Please specify first file name.");
                System.exit(-1);
            }
            fileName2 = console.readLine("Enter second file name: ");
            if (fileName2 == null || fileName2.isEmpty()) {
                System.err.println("Please specify second file name.");
                System.exit(-1);
            }
        } else {
            fileName1 = args[0];
            fileName2 = args[1];
        }

        Path path1 = Paths.get(fileName1);
        Path path2 = Paths.get(fileName2);

        try {
            Files.move(path1, path2, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Files moved successfully.");
        } catch (IOException ioe) {
            System.err.format("Error during processing files [ %s, %s ]: %s.", path1, path2, ioe.getMessage());
        }
    }
}
