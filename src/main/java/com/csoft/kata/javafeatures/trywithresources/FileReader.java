package com.csoft.kata.javafeatures.trywithresources;

import java.util.Scanner;

public class FileReader {

    public String readFileLegacy() {
        Scanner scanner = null;
        String buffer = "";
        try {
            scanner = new Scanner(FileReader.class.getResourceAsStream("/test.txt"));
            while (scanner.hasNext()) {
                buffer += scanner.nextLine() + System.lineSeparator();
            }
        } catch (Exception e) {
            // bouh
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return buffer;
    }

    public String readFileTryWithResources() {
        String buffer = "";
        try (Scanner scanner = new Scanner(FileReader.class.getResourceAsStream("/test.txt"))) {
            while (scanner.hasNext()) {
                buffer += scanner.nextLine() + System.lineSeparator();
            }
        }
        return buffer;
    }

    public static void main(String[] args) {
        var reader = new FileReader();
        System.out.println(reader.readFileLegacy());
        System.out.println(reader.readFileTryWithResources());
    }
}
