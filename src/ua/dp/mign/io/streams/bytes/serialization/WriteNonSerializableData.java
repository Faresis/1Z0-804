package ua.dp.mign.io.streams.bytes.serialization;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class WriteNonSerializableData {
    private static final String fileName = "object.data";
    public static void main(String[] args) {
        NonSerializableData data = new NonSerializableData("Jhon", "Smith", 3, 90.0, 34);

        System.out.println("Before: " + data);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
        } catch (FileNotFoundException fnfe) {
            System.err.format("File %s can't be found.", fileName);
        } catch (IOException ioe) {
            System.err.format("Error while processing file during writing %s: %s.%n", fileName, ioe.getMessage());
        }
        
        System.out.println("Serialization performed.");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();
            if (obj != null && obj instanceof NonSerializableData) {
                data = (NonSerializableData) obj;
                System.out.println("After: " + data);
            }
        } catch (FileNotFoundException fnfe) {
            System.err.format("File %s can't be found.", fileName);
        } catch (IOException ioe) {
            System.err.format("Error while processing file during reading %s: %s.%n", fileName, ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.err.format("Can't recognize class read from %s.", fileName);
        }
    }
}
