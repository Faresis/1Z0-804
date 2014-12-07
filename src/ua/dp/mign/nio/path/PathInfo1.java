package ua.dp.mign.nio.path;

import java.io.Console;
import java.nio.file.Paths;
import java.nio.file.Path;

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

        System.out.println("Printing elements of the path: ");
        for(Path element : testFilePath) {
            System.out.println("Path element: " + element);
        }
    }
}
