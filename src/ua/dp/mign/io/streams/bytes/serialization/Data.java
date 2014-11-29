package ua.dp.mign.io.streams.bytes.serialization;

import java.io.Serializable;

class Data implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private String name;
    private long count;
    private double degree;
    private transient int sessionId;

    public Data(String code, String name, long count, double degree, int sessionId) {
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
}
