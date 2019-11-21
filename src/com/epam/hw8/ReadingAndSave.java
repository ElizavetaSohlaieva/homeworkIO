package com.epam.hw8;

import java.io.*;
import java.util.Scanner;

public class ReadingAndSave {
    public ReadingAndSave() {
    }

    public void readingFile() throws IOException {


    String separator = File.separator;
    String testFile = separator + "C:" + separator + "Users" + separator + "Aspire" + separator + "Desktop" + separator + "test.txt";
    FileReader file = new FileReader(testFile);
    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()){
        System.out.println(scanner.nextLine());
    }
    file.close();
    }
    public void writingFile() throws IOException {
        String separator = File.separator;
        String textFile = separator + "C:" + separator + "Users" + separator + "Aspire" + separator + "Desktop" + separator + "test.txt";
        FileWriter fileWriter = new FileWriter(textFile, true);
        Scanner sc = new Scanner(System.in);
        fileWriter.write(sc.nextLine());
        fileWriter.write("\r\n");

        fileWriter.close();
    }
}
