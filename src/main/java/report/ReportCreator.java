package report;

import adapter.FileInterpreter;
import model.MyData;
import model.Task;
import model.TaskDao;
import service.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreator {

    public List<Task> filterByDate(List<Task> tasks, String start, String end) {


        MyData startDate = mapStringToMyDate(start);
        MyData endDate = mapStringToMyDate(end);

        TaskDao taskDao = new TaskDao(new FileInterpreter());
        Printer printer = new Printer();

        ReportCreator creator = new ReportCreator();
        Map<Task, Long> time = creator.computeTime(taskDao.getAll());


        return tasks.stream()
                .filter(t -> t.getStart().compareTo(startDate) <= 0)
                .filter(t -> t.getStop().compareTo(endDate) <= 0)
                .toList();
    }

    private MyData mapStringToMyDate(String date) {

        String[] split = date.split("-");

            MyData data = new MyData();
            data.setDay(Integer.parseInt(split[2]));
            data.setMonth(Integer.parseInt(split[1]));
            data.setYear(Integer.parseInt(split[0]));

            return data;

    }

    public List<Task> filterByProjectName(List<Task> tasks, String projectName) {
        return tasks.stream()
                .filter(t -> t.getTaskName()
                        .equals(projectName))
                .toList();
    }

    public Map<Task, Long> computeTime(List<Task> tasks) {
        return tasks.stream()
                .collect(Collectors.groupingBy(
                        t -> t, Collectors.summingLong(Task::getDuration)
                ));


    }
}
