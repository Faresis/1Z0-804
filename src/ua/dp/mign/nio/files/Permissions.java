package ua.dp.mign.nio.files;

import java.io.Console;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

class Permissions {
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
        System.out.printf("Readable: %b, Writable: %b, Executable: %b.%n",
                          Files.isReadable(path),
                          Files.isWritable(path),
                          Files.isExecutable(path));
    }
}
