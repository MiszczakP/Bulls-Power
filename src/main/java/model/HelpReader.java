package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelpReader {
//
//    public static void main(String args[]) throws Exception {
//        scanFile("res/help.txt");
//        readFile("res/help.txt", "stop");
//
//    }



    public static void readFile(String filename, String... keywords) throws Exception{
        File helpFile = new File(filename);
        int lineCounter = 0;
        int lineIndex = 0;

        Scanner scanner = new Scanner(helpFile);
        String patternString = "\\d\\.";
        Pattern pattern = Pattern.compile(patternString);



//        try (BufferedReader reader = Files.newBufferedReader(helpFile.toPath())) {
//            String line = reader.readLine();
//            Matcher matcher = pattern.matcher(reader.readLine());
//
//                for (String keyword : keywords){
//                    if (line.contains(keyword)) {
//                        System.out.println(scanner.nextLine());
//                        lineCounter++;
//                        if(matcher.matches()) {
//                            break;
//                        }
//                        // show only once line, even when you find to words
//                    }
//                }
//
//            System.out.println ("Numbers of lines: " + lineCounter);
//
//
//        } catch (IOException x) {
//            System.err.format("IOException: %s", x);
//        }

    }

}
