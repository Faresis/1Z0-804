package ua.dp.mign.io.streams.bytes.serialization;

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class ReadVersionedData {
    private static final String fileName = "object.data";
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();
            if (obj != null && obj instanceof VersionedData) {
                VersionedData data = (VersionedData) obj;
                System.out.println("After: " + data);
                System.out.println("Data read.");
            }
        } catch (FileNotFoundException fnfe) {
            System.err.format("File %s can't be found.", fileName);
        } catch (IOException ioe) {
            System.err.format("Error while processing file during read %s: %s.", fileName, ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.err.format("Can't recognize class read from %s.", fileName);
        }
    }
}
