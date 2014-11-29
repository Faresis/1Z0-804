package ua.dp.mign.io.streams.bytes.serialization;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class WriteVersionedData {
    private static final String fileName = "object.data";
    public static void main(String[] args) {
        VersionedData data = new VersionedData("Jhon", "Smith", 3, 90.0, 34, null);
        data.setData(data);

        System.out.println("Before: " + data);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
        } catch (FileNotFoundException fnfe) {
            System.err.format("File %s can't be found.", fileName);
        } catch (IOException ioe) {
            System.err.format("Error while processing file during write %s: %s.", fileName, ioe.getMessage());
        }

        System.out.println("Data saved.");
    }
}
