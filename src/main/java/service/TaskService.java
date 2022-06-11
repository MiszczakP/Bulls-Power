package service;

import adapter.FileInterpreter;
import lombok.RequiredArgsConstructor;
import model.Task;
import model.TaskDao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;


public class TaskService {

    private final TaskDao taskDao;
    private List<Task> tasks;

    public TaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
        tasks = taskDao.getAll();
    }

    public void start(String projectName, String taskName) throws IOException {

        if (!tasks.isEmpty()){
            Task lastTask = tasks.get(taskDao.getAll().size() - 1);

            if (lastTask.getStop() == null) {
                lastTask.setStop(LocalDateTime.now());
            }
        }

        Task task = new Task(projectName, taskName);
        tasks.add(new Task(projectName, taskName));

        taskDao.save(tasks);
        System.out.println("save");

        System.out.println(projectName + " " + projectName + "started " + task.getStart());


    }

    public void stop() throws IOException {

        Task lastTask = tasks.get(taskDao.getAll().size() - 1);
        lastTask.setStop(LocalDateTime.now());


        taskDao.save(tasks);
        System.out.println("saved");

        System.out.println(lastTask.getProjectName() + " " + lastTask.getTaskName() + " finished" + lastTask.getStop());
        System.out.println("Duration: " + Duration.between(lastTask.getStop(),lastTask.getStart()));

    }

    public void printCurrent() {
        Task task = taskDao.getAll()
                .get(taskDao.getAll().size() - 1);


        if (task.getStop() != null) {
            System.out.println("No open tasks");
        } else {
            System.out.println(task);
        }

    }


    public void printAll() throws FileNotFoundException {
        taskDao.getAll().forEach(System.out::println);
    }
}
