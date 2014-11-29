package ua.dp.mign.io.streams.bytes;

import java.util.Set;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class WriteObjects {
    private static final String fileName = "object.data";
    public static void main(String[] args) {
        Map<String, String> dict = new HashMap<>();
        dict.put("A", "Alpha");
        dict.put("B", "Beta");
        dict.put("G", "Gamma");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(dict);
        } catch (FileNotFoundException fnfe) {
            System.err.format("File %s can't be found.", fileName);
        } catch (IOException ioe) {
            System.err.format("Error while processing file %s.", fileName);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();
            if (obj != null && obj instanceof Map) {
                Map<?,?> rDict = (Map) obj;
                for(Entry<?,?> pair : rDict.entrySet()) {
                    System.out.printf("Code: %s%nValue:%s%n", pair.getKey(), pair.getValue());
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.err.format("File %s can't be found.", fileName);
        } catch (IOException ioe) {
            System.err.format("Error while processing file %s.", fileName);
        } catch (ClassNotFoundException cnfe) {
            System.err.format("Can't recognize class read from %s.", fileName);
        }
    }
}
