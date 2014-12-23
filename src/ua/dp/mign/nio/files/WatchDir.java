package ua.dp.mign.nio.files;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.WatchService;
import java.nio.file.WatchKey;
import java.nio.file.WatchEvent;
import java.nio.file.StandardWatchEventKinds;


class WatchDir {
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
        WatchService watchService = null;
        try {
            watchService = path.getFileSystem().newWatchService();
            path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        } catch (IOException ioe) {
            System.err.printf("Error while processing file %s: %s.%n", path, ioe.getMessage());
        }

        while(true) {
            WatchKey events = null;
            try {
                events = watchService.take();
            } catch (InterruptedException e) {
                System.err.println("Error while getting event.");
                System.exit(-1);
            }

            for (WatchEvent<?> event : events.pollEvents()) {
                switch(event.kind().name()) {
                    case "OVERFLOW":
                        System.out.println("Some events were lost.");
                        break;
                    case "ENTRY_MODIFY":
                        System.out.printf("File %s is changed.%n", event.context());
                        break;
                }
            }
            events.reset();
        }
    }
}
