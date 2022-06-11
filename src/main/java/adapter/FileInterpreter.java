package adapter;

import model.Task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileInterpreter {

    public List<Task> readDocumentsInDataFolder() throws FileNotFoundException {

        List<Task> listOfTasks = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("data/test_file.csv"))) {
            while (scanner.hasNextLine()) {
                listOfTasks.add(getRecordFromLine(scanner.nextLine()));
            }
        }

        return listOfTasks;
    }

    private Task getRecordFromLine(String line) {
        Task task = new Task();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(";");
            task.setProjectName(rowScanner.next());
            System.out.println("PRO: " + task.getProjectName());
            task.setTaskName(rowScanner.next());
            System.out.println("TASK: " + task.getTaskName());
            task.setStart(formatter(rowScanner.next()));
            System.out.println("START: " + task.getStart());
            task.setStop(formatter(rowScanner.next()));
            System.out.println("STOP: " + task.getStop());
        }
        return task;
    }

    private LocalDateTime formatter(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(str, formatter);
    }

}