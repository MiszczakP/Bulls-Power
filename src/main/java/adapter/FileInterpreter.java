package adapter;

import model.MyData;
import model.Task;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileInterpreter {

    public void saveDataToDocument(List<Task> input) {

        try (FileWriter writer = new FileWriter("data/test.csv")) {
            for (Task task : input) {

                String startMonth = String.valueOf(task.getStart().getMonth());
                String endMonth = String.valueOf(task.getStop().getMonth());

                if (task.getStart().getMonth() < 10) {
                    startMonth = "0" + startMonth;
                }

                if (task.getStop().getMonth() < 10 && task.getStop().getMonth() != 0) {
                    endMonth = "0" + endMonth;
                }

                writer.append(task.getProjectName());
                writer.append(';');
                writer.append(task.getTaskName());
                writer.append(';');
                writer.append(task.getDuration().toString());
                writer.append(';');
//                writer.append(task.getStart().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                writer.append(
                        String.valueOf(task.getStart().getYear())).append("-").append(startMonth).append("-").append(
                        String.valueOf(task.getStart().getDay())).append(" ").append(
                        String.valueOf(task.getStart().getHour())).append(":").append(
                        String.valueOf(task.getStart().getMinute()));
                writer.append(';');
                if (task.getStop() == null) {
                    writer.append("");
                } else {
//                    writer.append(task.getStop().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                    writer.append(
                            String.valueOf(task.getStop().getYear())).append("-").append(endMonth).append("-").append(
                            String.valueOf(task.getStop().getDay())).append(" ").append(
                            String.valueOf(task.getStop().getHour())).append(":").append(
                            String.valueOf(task.getStop().getMinute()));
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
                try {


                    listOfTasks.add(getRecordFromLine(scanner.nextLine()));
                }catch (NoSuchElementException e) {
                    listOfTasks.add(getRecordFromLine(scanner.nextLine()));
                }
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
            task.setDuration(Long.valueOf(rowScanner.next()));
//            task.setStart(formatter(rowScanner.next()));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(rowScanner.next(), formatter);

            task.setStart(new MyData());
            task.getStart().setYear(dateTime.getYear());
            task.getStart().setMonth(dateTime.getMonthValue());
            task.getStart().setDay(dateTime.getDayOfMonth());
            task.getStart().setHour(dateTime.getHour());
            task.getStart().setMinute(dateTime.getMinute());

            if (rowScanner.hasNext()) {
//                task.setStop(formatter(rowScanner.next()));
                task.setStop(new MyData());
                task.getStop().setYear(dateTime.getYear());
                task.getStop().setMonth(dateTime.getMonthValue());
                task.getStop().setDay(dateTime.getDayOfMonth());
                task.getStop().setHour(dateTime.getHour());
                task.getStop().setMinute(dateTime.getMinute());
            } else {
                task.setStop(MyData.emptyMyData());
            }
        }
        return task;
    }

    private LocalDateTime formatter(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(str, formatter);
    }



}
