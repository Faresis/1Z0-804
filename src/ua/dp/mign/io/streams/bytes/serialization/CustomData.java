package ua.dp.mign.io.streams.bytes.serialization;

import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
 * In this example serialization process is overridden
 * by the type itself and so modifiers such as transient
 * are not considered.
 * When user overrides readObject and writeObject it is
 * on his choice how to serialize an object.
 */
class CustomData implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private String name;
    private long count;
    private double degree;
    private CustomData data;
    private transient int sessionId;

    public CustomData() {}

    public CustomData(String code, String name, long count, double degree, int sessionId, CustomData data) {
        this.code = code;
        this.name = name;
        this.count = count;
        this.degree = degree;
        this.sessionId = sessionId;
        this.data = data;
    }

    public void setData(CustomData data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return String.format("Code: %s\tName: %s\t Count: %d\t Degree: %f\t Session: %d\t Contain link to itself: %b",
                              code, name, count, degree, sessionId, this == data);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        PrintWriter printer = new PrintWriter(out);
        printer.format("Code: %s\tName: %s\t Count: %d\t Degree: %f\t Session: %d\t Contain link to itself: %b",
                       code, name, count, degree, sessionId, this == data);
        printer.flush();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        InputStreamReader reader = new InputStreamReader(in);
        StringWriter writer = new StringWriter();
        int ch;
        while((ch = reader.read()) != -1) {
            writer.write((char)ch);
        }
        Pattern pattern = Pattern.compile("Code:\\s+(\\w+)\\s+Name:\\s+(\\w+)\\s+Count:\\s+(\\d+)\\s+Degree:\\s+(\\d+\\.\\d+)\\s+Session:\\s+(\\d+)");
        String str = writer.toString();
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()) {
            this.code = matcher.group(1);
            this.name = matcher.group(2);
            this.count = Long.parseLong(matcher.group(3));
            this.degree = Double.parseDouble(matcher.group(4));
            this.sessionId = Integer.parseInt(matcher.group(5));
        } else {
            System.out.println("Pattern failed.");
        }
    }
}
