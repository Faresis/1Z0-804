package ua.dp.mign.nio.files;

import java.io.Console;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

class Exists {
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

        if (Files.exists(path)) {
            System.out.printf("File/directory %s exists.%n", path);
            if (Files.isDirectory(path)) {
                System.out.printf("%s is a directory.%n", path.getFileName());
            } else {
                System.out.printf("%s is a file.%n", path.getFileName());
            }
        } else {
            System.out.printf("File/directory %s does not exists.%n", path);
        }
    }
}
