package ua.dp.mign.io.streams.bytes.serialization;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.NotSerializableException;
import java.io.IOException;

class NonSerializableData implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private String name;
    private long count;
    private double degree;
    private transient int sessionId;

    public NonSerializableData(String code, String name, long count, double degree, int sessionId) {
        this.code = code;
        this.name = name;
        this.count = count;
        this.degree = degree;
        this.sessionId = sessionId;
    }
    
    @Override
    public String toString() {
        return String.format("Code: %s\tName: %s\t Count: %d\t Degree: %f\t Session: %d", code, name, count, degree, sessionId);

    }

    /*
     * Serialization of an object can be explicitly prevented by overriding
     * readObject and writeObject methods with throwing NotSerializableException
     * from them.
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        throw new NotSerializableException();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        throw new NotSerializableException();
    }
}
