package ua.dp.mign.nio.files;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.PathMatcher;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;

class FindFileVisitor extends SimpleFileVisitor<Path> {
    private PathMatcher matcher;
    public FindFileVisitor(String pattern) {
        try {
            this.matcher = FileSystems.getDefault().getPathMatcher(pattern);
        } catch (IllegalArgumentException iae) {
            System.err.println("Invalid pattern.");
            System.exit(-1);
        }
    }
    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attr) {
        check(path);
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attr) {
        check(path);
        return FileVisitResult.CONTINUE;
    }
    private void check(Path path) {
        if(matcher.matches(path.getFileName())) {
            System.out.printf("Matching file %s%n", path.getFileName());
        }
    }
}

class FindFiles {
    public static void main(String args[]) {
        String fileName;
        String pattern;
        if (args.length != 2) {
            Console console = System.console();
            fileName = console.readLine("Enter file name: ");
            if (fileName == null || fileName.isEmpty()) {
                System.err.println("Please specify file name.");
                System.exit(-1);
            }
            pattern = console.readLine("Enter pattern to search: ");
            if (pattern == null || pattern.isEmpty()) {
                System.err.println("Please specify pattern.");
                System.exit(-1);
            }
        } else {
            fileName = args[0];
            pattern = args[1];
        }

        Path path = Paths.get(fileName);
        try {
            Files.walkFileTree(path, new FindFileVisitor(pattern));
        } catch ( IOException ioe) {
            System.err.printf("Error during processing file %s: %s.%n", path, ioe.getMessage());
        }
    }
}
