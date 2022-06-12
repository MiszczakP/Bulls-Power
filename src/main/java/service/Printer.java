package service;

import adapter.FileInterpreter;
import model.MyData;
import model.Task;
import model.TaskDao;

import java.util.List;

public class Printer {

    TaskDao taskService = new TaskDao(new FileInterpreter());

    private List<Task> tasks = taskService.getAll();

    @Override
    public String toString() {
        return "Printer{" +
                "tasks=" + tasks +
                '}';
    }


    public void printTasks() {
        int nameLength = 0;
        int projectLength = 0;



        for (Task task : tasks) {
            if (task.getTaskName().length() > nameLength) {
                nameLength = task.getTaskName().length();
            }

            if (task.getProjectName().length() > projectLength) {
                projectLength = task.getProjectName().length();
            }
        }

        for (Task task : tasks) {


            MyData start = task.getStart();
            int startYear = start.getYear();
            int startMonth = start.getMonth();
            String startMonths = String.valueOf(startMonth);
            if (startMonth < 10) {
                startMonths = "0" + startMonths;
            }

            int startDay = start.getDay();

            int startHour = start.getHour();
            int startMinutes = start.getMinute();

            String startDate = String.valueOf(startYear) + "-" + startMonths + "-" + String.valueOf(startDay);
            String startTime = String.valueOf(startHour) + ":" + String.valueOf(startMinutes);


            MyData stop = task.getStop();
            int stopYear = stop.getYear();
            int stopMonth = stop.getMonth();
            String stopMonths = String.valueOf(stopMonth);
            if (stopMonth < 10) {
                stopMonths = "0" + stopMonths;
            }

            int stopDay = stop.getDay();

            int stopHour = stop.getHour();
            int stopMinutes = stop.getMinute();

            String stopDate = String.valueOf(stopYear) + "-" + stopMonths + "-" + String.valueOf(stopDay);
            String stopTime = String.valueOf(stopHour) + ":" + String.valueOf(stopMinutes);

            String printProjectName = task.getProjectName() + " ".repeat(projectLength - task.getProjectName().length() + 1);
            String printTaskName = task.getTaskName() + " ".repeat(nameLength - task.getTaskName().length() + 1);
            String printStartTime = startDate + " " +startTime;
            String printStopTime = stopDate + " " +stopTime;

            if (stopDate.equals("0-00-0")) {
                printStopTime = "Zadanie w trakcie wykonywania";
            }

            System.out.println(printProjectName + printTaskName + printStartTime + " " + printStopTime);
        }
    }
}






