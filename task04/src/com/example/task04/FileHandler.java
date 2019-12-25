package com.example.task04;

import java.io.*;

/**
 * Обработчик для вывода сообщений в файл
 */
public class FileHandler implements MessageHandler {

    private FileWriter writer;

    public FileHandler(String fileName) throws IOException {
        this.writer = new FileWriter(fileName, true);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    @Override
    public void printMessage(String message) throws IOException {
        writer.write(message);
        writer.flush();
    }

}