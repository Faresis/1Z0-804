package ua.dp.mign.io.streams.bytes.serialization;

import java.io.Serializable;

/*
 * During serialization all fields except sessionId
 * will be serialized. It will be ignored because
 * it is marked with transient flag.
 */
class SerializableData implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private String name;
    private long count;
    private double degree;
    private SerializableData data;
    private transient int sessionId;

    public SerializableData() {}

    public SerializableData(String code, String name, long count, double degree, int sessionId, SerializableData data) {
        this.code = code;
        this.name = name;
        this.count = count;
        this.degree = degree;
        this.sessionId = sessionId;
        this.data = data;
    }

    public void setData(SerializableData data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return String.format("Code: %s\tName: %s\t Count: %d\t Degree: %f\t Session: %d\t Contain link to itself: %b",
                              code, name, count, degree, sessionId, this == data);

    }
}
