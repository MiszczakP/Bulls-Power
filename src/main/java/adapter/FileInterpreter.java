package adapter;

import model.Task;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInterpreter {

    public void saveDataToDocument(List<Task> input) {

        try (FileWriter writer = new FileWriter("data/test.csv")) {
            for (Task task : input) {
                writer.append(task.getProjectName());
                writer.append(';');
                writer.append(task.getTaskName());
                writer.append(';');
                writer.append(task.getStart().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                writer.append(';');
                if (task.getStop() == null) {
                    writer.append("");
                } else {
                    writer.append(task.getStop().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                }
                writer.append('\n');
            }
        } catch (IOException e) {
            System.err.println("Can`t save! File not found!");
        }

    }

    public List<Task> readDocumentsInDataFolder()  {

        List<Task> listOfTasks = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("data/test.csv"))) {
            while (scanner.hasNextLine()) {
                listOfTasks.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }

        return listOfTasks;
    }

    private Task getRecordFromLine(String line) {
        Task task = new Task();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(";");
            task.setProjectName(rowScanner.next());
            task.setTaskName(rowScanner.next());
            task.setStart(formatter(rowScanner.next()));
            if (rowScanner.hasNext()) {
                task.setStop(formatter(rowScanner.next()));
            } else {
                task.setStop(null);
            }
        }
        return task;
    }

    private LocalDateTime formatter(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(str, formatter);
    }



}
