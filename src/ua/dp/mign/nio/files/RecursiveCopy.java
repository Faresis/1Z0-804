package ua.dp.mign.nio.files;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;

class CopyFileVisitor extends SimpleFileVisitor<Path> {
    private Path src, dst;

    public CopyFileVisitor(Path src, Path dst) {
        this.src = src;
        this.dst = dst;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        Path destFile = dst.resolve(src.relativize(file));
        try {
            Files.copy(file, destFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            System.err.printf("Error during processing file %s: %s.", file, ioe.getMessage());
        }
        return FileVisitResult.CONTINUE;
    } 
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        Path destDir = dst.resolve(src.relativize(dir));
        try {
            Files.copy(dir, destDir, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            System.err.printf("Error during processing file %s: %s.", dir, ioe.getMessage());
        }
        return FileVisitResult.CONTINUE;
    }
}

class RecursiveCopy {
    public static void main(String args[]) {
        String fileName1;
        String fileName2;
        if (args.length != 2) {
            Console console = System.console();
            fileName1 = console.readLine("Enter source file name: ");
            if (fileName1 == null || fileName1.isEmpty()) {
                System.err.println("Please specify first file name.");
                System.exit(-1);
            }
            fileName2 = console.readLine("Enter destination file name: ");
            if (fileName2 == null || fileName2.isEmpty()) {
                System.err.println("Please specify second file name.");
                System.exit(-1);
            }
        } else {
            fileName1 = args[0];
            fileName2 = args[1];
        }

        Path src = Paths.get(fileName1);
        Path dest = Paths.get(fileName2);

        try {
            Files.walkFileTree(src, new CopyFileVisitor(src, dest));
            System.out.println("Files copied successfully.");
        } catch (IOException ioe) {
            System.err.format("Error during processing files [ %s, %s ]: %s.", src, dest, ioe.getMessage());
        }
    }
}
