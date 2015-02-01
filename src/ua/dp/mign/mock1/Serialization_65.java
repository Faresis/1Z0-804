package ua.dp.mign.mock1;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

class USPresident implements Serializable {
    private static final long serialVersionUID = 1L;
    @Override
    public String toString() {
        return "US President [name=" + name +
               ", period=" + period +
               ", term=" + term + "]";
    }

    public USPresident(String name, String period, String term) {
        this.name = name;
        this.period = period;
        this.term = term;
    }
    private String name;
    private String period;
    /*
     * static fields are ignored during serialization
     * and are not written to the persistent storage
     * no matter if they are marked as transient or not.
     */ 
    private static transient String term;
}

class Serialization_65 {
    public static void main(String[] args) {
        USPresident usPresident = new USPresident("Barak Obama",
                                                  "2009 to --",
                                                  "56th term");
        System.out.println(usPresident);
        writePresident(usPresident);
        usPresident = readPresident();
        System.out.println(usPresident);
    }

    private static void writePresident(USPresident usPresident) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                                        new FileOutputStream(
                                            "USPresident.data"))) {
            oos.writeObject(usPresident);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static USPresident readPresident() {
        USPresident presidentOfUS = null;
        try (ObjectInputStream ois = new ObjectInputStream(
                                        new FileInputStream(
                                            "USPresident.data"))) {
            Object obj = ois.readObject();
            if(obj != null && obj instanceof USPresident) {
                presidentOfUS = (USPresident) obj;
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return presidentOfUS;
    }
}
