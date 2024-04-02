package be.app.Todo.service;

import be.app.Todo.exception.RestExceptionHandler;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TextFileService {
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
    private static final String FILE_PATH = "errorMessages.txt";

    public void saveMessage(String message) {

        try {
            logger.info("Message saved successfully: {}", message);
        } catch (Exception e) {
            logger.error("Failed to save message: {}", message, e);
        }
    }
}

