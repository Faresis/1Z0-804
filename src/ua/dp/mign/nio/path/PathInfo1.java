package ua.dp.mign.nio.path;

import java.io.Console;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.LinkOption;
import java.io.IOException;

class PathInfo1 {
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

        Path testFilePath = Paths.get(fileName);
        System.out.println("Printing file information: ");
        System.out.println("File name: " + testFilePath.getFileName());
        System.out.println("Root: " + testFilePath.getRoot());
        System.out.println("Parent: " + testFilePath.getParent());
        System.out.println("URI: " + testFilePath.toUri());
        System.out.println("Absolute path: " + testFilePath.toAbsolutePath());
        System.out.println("Normalized path: " + testFilePath.normalize());
        System.out.println("Normalized absolute path: " + testFilePath.normalize().toAbsolutePath());

        System.out.println("Printing elements of the path: ");
        for(Path element : testFilePath) {
            System.out.println("Path element: " + element);
        }
        try {
            System.out.println("Real path: " + testFilePath.toRealPath(LinkOption.NOFOLLOW_LINKS));
        } catch (IOException ioe) {
            System.err.printf("Error during processing file %s.", testFilePath);
        }
    }
}
