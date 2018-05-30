package com.javarush.task.task33.task3310.strategy;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile("tmp", null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {

        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() throws IOException {
        return Files.size(path);

    }

    public void putEntry(Entry entry) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));
            oos.writeObject(entry);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Entry getEntry() throws IOException {
        if (getFileSize() <= 0) return null;
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
            return (Entry) in.readObject();
        } catch (Exception e) {
        }
        return null;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
