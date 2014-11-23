package ua.dp.mign.io.streams.bytes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class Primitives {
    public static void main(String[] args) {
        final String fileName = "temp.data";
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            for(int i = 0; i < 10; i++) {
                dos.writeByte(i);
                dos.writeShort(i);
                dos.writeInt(i);
                dos.writeLong(i);
                dos.writeFloat(i);
                dos.writeDouble(i);
            }
        } catch (FileNotFoundException fnfe) {
            System.err.printf("File %s can't be found.", fileName);
            System.exit(-1);
        } catch (IOException ioe) {
            System.err.printf("Error while processing file %s.", fileName);
            System.exit(-1);
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            for(int i = 0; i < 10; i++) {
                System.out.printf("%d %d %d %d %g %g %n",
                                  dis.readByte(),
                                  dis.readShort(),
                                  dis.readInt(),
                                  dis.readLong(),
                                  dis.readFloat(),
                                  dis.readDouble());
            }
        } catch (FileNotFoundException fnfe) {
            System.err.printf("File %s can't be found.", fileName);
            System.exit(-1);
        } catch (IOException ioe) {
            System.err.printf("Error while processing file %s.", fileName);
            System.exit(-1);
        }
    }
}
