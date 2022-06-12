package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class HelpTest {

    public static void main(String args[]) throws Exception {

// File file = new File ("res/cwiczenie1/poem.txt");

        scanFile("res/cwiczenie1/poem.txt","ale");

        readFile("res/cwiczenie1/poem.txt", "!","ale");
        System.out.println(" ");

// readFile("res/cwiczenie1/poem.txt","keyword1", "keyword2");
        readChars("res/cwiczenie1/poem.txt");

    }


    public static void readChars(String filename){
        File poemFile = new File(filename);

        try (BufferedReader reader = Files.newBufferedReader(poemFile.toPath())) {
            int character;
//jak funkcja zwroci -1 to koniec pliku!! bo liczymy od 0
            while ((character = reader.read()) != -1) {
                System.out.println((char)character);
                if ((char)character == '\n') {
                    System.out.println("line end ");
                }
            }
        } catch (IOException x) {
            System.err.format("IOException: %s", x);
        }

    }
    public static void readFile(String filename, String... keywords){
        File poemFile = new File(filename);
        int lineCounter = 0;
        int lineIndex = 0;


        try (BufferedReader reader = Files.newBufferedReader(poemFile.toPath())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                lineIndex++;

                for (String keyword : keywords){
                    if (line.contains(keyword)) {
                        System.out.println(line);
                        lineCounter++;
                        break; // show only once line, even when you find to words
                    }
                }
            }
            System.out.println ("Numbers of lines: " + lineCounter);


        } catch (IOException x) {
            System.err.format("IOException: %s", x);
        }

    }

    private static void scanFile(String filename, String keyword) throws Exception {
        File poemFile = new File(filename);
        Scanner scanner = new Scanner(poemFile);
        int keywordCount = 0;
        while (scanner.hasNext()) {
            String token = scanner.next();


            if (token.contains(keyword)){
                keywordCount++;
                System.out.println(token);
            }

        }
        scanner.close();
        System.out.println(" ");
        System.out.println("----------------------------------------");
        System.out.println("Found tokens:"+ keywordCount);
        System.out.println("Filepath: "+poemFile.getAbsolutePath());
        System.out.println("Free space: "+poemFile.getFreeSpace()/(1024*1024) + " MB");
        System.out.println("Free space: "+poemFile.getFreeSpace()/(1024*1024*1024) + " GB");

    }

}