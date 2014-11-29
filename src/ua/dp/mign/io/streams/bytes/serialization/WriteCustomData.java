package ua.dp.mign.io.streams.bytes.serialization;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class WriteCustomData {
    private static final String fileName = "object.data";
    public static void main(String[] args) {
        CustomData data = new CustomData("Jhon", "Smith", 3, 90.0, 34, null);
        data.setData(data);

        System.out.println("Before: " + data);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
        } catch (FileNotFoundException fnfe) {
            System.err.format("File %s can't be found.", fileName);
        } catch (IOException ioe) {
            System.err.format("Error while processing file %s: %s.", fileName, ioe.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();
            if (obj != null && obj instanceof CustomData) {
                data = (CustomData) obj;
                System.out.println("After: " + data);
            }
        } catch (FileNotFoundException fnfe) {
            System.err.format("File %s can't be found.", fileName);
        } catch (IOException ioe) {
            System.err.format("Error while processing file %s: %s.", fileName, ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.err.format("Can't recognize class read from %s.", fileName);
        }
    }
}
