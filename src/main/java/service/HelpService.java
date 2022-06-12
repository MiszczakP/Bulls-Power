package service;

import java.io.File;
import java.util.Scanner;

public class HelpService {
    private final String fileUrl = "res/help.txt";

    public void printHelp() {

        File helpFile = new File(fileUrl);

        try (Scanner scanner = new Scanner(helpFile);)
        {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }

        } catch (Exception e) {
            System.err.println("Can`t read help file!");
        }
    }
}
