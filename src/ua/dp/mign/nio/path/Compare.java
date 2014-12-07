package ua.dp.mign.nio.path;

import java.io.Console;
import java.nio.file.Paths;
import java.nio.file.Path;

class Compare {
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

        System.out.println("path1.equals(path2): " + path1.equals(path2));
        System.out.println("(path1.compareTo(path2) == 0): " + (path1.compareTo(path2) == 0));
        System.out.println("path1.toAbsolutePath().equals(path2.toAbsolutePath()): " + path1.toAbsolutePath().equals(path2.toAbsolutePath()));
        System.out.println("path1.normalize().toAbsolutePath().equals(path2.normalize().toAbsolutePath()): " + path1.normalize().toAbsolutePath().equals(path2.normalize().toAbsolutePath()));
    }
}
