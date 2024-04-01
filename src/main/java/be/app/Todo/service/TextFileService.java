package be.app.Todo.service;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
@Service
public class TextFileService {
    private static final String FILE_PATH = "errorMessages.txt";

    public void saveMessage(String message) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
