package org.example.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperationTXT{



    public void saveAllLines(String line, String fileName) throws IOException {
        fileName = fileName + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
                writer.write(line);
                writer.append('\n');
                writer.flush();
        } catch (IOException ex) {
                throw new IOException("Файл не найден");
            }
    }
}
