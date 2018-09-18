package io.github.perrymant.moneymaker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class SerializedObject implements Serializable {

    String loadData(String objectFileName) {
        String readObject;
        try (ObjectInputStream objectStream =
                     new ObjectInputStream(Files.newInputStream(Paths.get(objectFileName)))) {
            readObject = (String) objectStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new SerializedObjectError("Exception: Couldn't read ObjectInputStream!", e);
        }
        return readObject;
    }

    void saveData(String data, String objectFileName) {
        try (ObjectOutputStream objectStream =
                     new ObjectOutputStream(Files.newOutputStream(Paths.get(objectFileName)))) {
            objectStream.writeObject(data);
        } catch (IOException e) {
            throw new SerializedObjectError("Exception: Couldn't create ObjectOutputStream!", e);
        }
    }

    //    append cannot work properly!!!
    void appendData(String data, String objectFileName) {
        try (AppendingObjectOutputStream objectStream =
                     new AppendingObjectOutputStream(Files.newOutputStream(Paths.get(objectFileName)))) {
            objectStream.writeObject(data);
        } catch (IOException e) {
            throw new SerializedObjectError("Exception: Couldn't append ObjectOutputStream!", e);
        }
    }

    public class AppendingObjectOutputStream extends ObjectOutputStream {

        AppendingObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }

    }

    private class SerializedObjectError extends RuntimeException {
        SerializedObjectError(String message, Exception e) {
            super(message, e);
        }
    }
}
