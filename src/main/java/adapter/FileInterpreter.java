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

        try (FileWriter writer = new FileWriter("./Tasks.csv")) {
            for (Task task : input) {

                String startDays = checkDay(task.getStart());
                String stopDays = checkDay(task.getStop());
                String startMonth = checkMonth(task.getStart());
                String stopMonth = checkMonth(task.getStop());
                String startMins = checkMinutes(task.getStart());
                String stopMins = checkMinutes(task.getStop());
                String startHours = checkHours(task.getStart());
                String stopHours = checkHours(task.getStop());

                writer.append(task.getProjectName());
                writer.append(';');
                writer.append(task.getTaskName());
                writer.append(';');
                writer.append(task.getDuration().toString());
                writer.append(';');
                writer.append(String.valueOf(task.getStart().getYear())).append("-")
                        .append(startMonth).append("-").append(startDays).append(" ")
                        .append(startHours).append(":").append(startMins);
                writer.append(';');
                if (task.getStop() == null) {
                    writer.append("");
                } else {
                    writer.append(String.valueOf(task.getStop().getYear())).append("-")
                            .append(stopMonth).append("-").append(stopDays).append(" ")
                            .append(stopHours).append(":").append(stopMins);
                }
                writer.append('\n');
            }
        } catch (IOException e) {
            System.err.println("Can`t save! File not found!");
        }

    }

    public List<Task> readDocumentsInDataFolder()  {

        File file = new File("./Tasks.csv");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<Task> listOfTasks = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("./Tasks.csv"))) {
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

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(rowScanner.next(), formatter);

            task.setStart(new MyData());
            task.getStart().setYear(dateTime.getYear());
            task.getStart().setMonth(dateTime.getMonthValue());
            task.getStart().setDay(dateTime.getDayOfMonth());
            task.getStart().setHour(dateTime.getHour());
            task.getStart().setMinute(dateTime.getMinute());

            if (rowScanner.hasNext()) {
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

    private String checkDay(MyData time) {
        String couter = String.valueOf(time.getDay());
        if (time.getDay() < 10 && time.getDay() != 0) {
            couter = "0" + couter;
        }
        return couter;
    }

    private String checkMonth(MyData time) {
        String couter = String.valueOf(time.getMonth());
        if (time.getMonth() < 10 && time.getMonth() != 0) {
            couter = "0" + couter;
        }
        return couter;
    }

    private String checkMinutes(MyData time) {
        String couter = String.valueOf(time.getMinute());
        if (time.getMinute() < 10 && time.getMinute() != 0) {
            couter = "0" + couter;
        }
        return couter;
    }

    private String checkHours(MyData time) {
        String couter = String.valueOf(time.getHour());
        if (time.getHour() < 10 && time.getHour() != 0) {
            couter = "0" + couter;
        }
        return couter;
    }


}
