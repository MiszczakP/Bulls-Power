package model;

import java.io.File;
import java.util.Scanner;

public class ShowHelp {
    private final String fileUrl = "res/help.txt";

    private static void printHelp(String fileUrl) throws Exception {
        

        File helpFile = new File(fileUrl);
        Scanner scanner = new Scanner(helpFile);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();

    }
}
