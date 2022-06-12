package report;

import adapter.FileInterpreter;
import model.MyData;
import model.Task;
import model.TaskDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreator {

    public static void main(String[] args) {

        TaskDao taskDao = new TaskDao(new FileInterpreter());

        ReportCreator creator = new ReportCreator();
        Map<Task, Long> time = creator.computeTime(taskDao.getAll());

        time.keySet().forEach(k -> {
            System.out.println(k + " " + time.get(k));
        });

    }

    // 7 dni wstecz
    // tydzien zacyznajacy sie od poniedzialku
    // wybrana data, jeden dzien,
    // zakres dat\
    // miesieczne

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
