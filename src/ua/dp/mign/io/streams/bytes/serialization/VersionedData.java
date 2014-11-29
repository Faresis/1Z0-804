package ua.dp.mign.io.streams.bytes.serialization;

import java.io.Serializable;

/*
 * During serialization all fields except sessionId
 * will be serialized. It will be ignored because
 * it is marked with transient flag.
 * If serialVersionUID will be modified and class
 * recompiled all versions of this class persisted
 * before will not be available for reading.
 * During reading of such an old version exception
 * will be thrown by an ObjectInputStream
 * This field should be modified each time class
 * state structure is changed. Otherwise during
 * object restoration newly added/removed fields
 * will be ignored and object state may be
 * inconsistent.
 */
class VersionedData implements Serializable {
    private static final long serialVersionUID = 2L;

    private String name;
    private long count;
    private double degree;
    private VersionedData data;
    private transient int sessionId;
    private String additionalField;
    private int additionalInt;

    public VersionedData() {}

    public VersionedData(String name, long count, double degree, int sessionId, VersionedData data) {
        this.name = name;
        this.count = count;
        this.degree = degree;
        this.sessionId = sessionId;
        this.data = data;
    }

    public void setData(VersionedData data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return String.format("Name: %s\t Count: %d\t Degree: %f\t Session: %d\t Contain link to itself: %b\t Add. fld: %s\t Add. num: %d",
                              name, count, degree, sessionId, this == data, additionalField, additionalInt);

    }
}
