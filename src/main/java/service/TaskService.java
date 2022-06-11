package service;

import adapter.FileInterpreter;
import lombok.RequiredArgsConstructor;
import model.Task;
import model.TaskDao;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class TaskService {

    private final TaskDao taskDao;

    public void start(String projectName, String taskName) throws FileNotFoundException {

        Task lastTask = taskDao.getAll().get(taskDao.getAll().size() - 1);

        if (lastTask.getStop() == null) {
            lastTask.setStop(LocalDateTime.now());
        }

        Task task = new Task(projectName, taskName);
        taskDao.getAll().add(new Task(projectName, taskName));

        //helper.save(all);
        System.out.println("save");

        System.out.println(projectName + " " + projectName + "started " + task.getStart());


    }

    public void stop() throws FileNotFoundException {


        Task lastTask = taskDao.getAll().get(taskDao.getAll().size() - 1);
        lastTask.setStop(LocalDateTime.now());

        //helper.save(all);
        System.out.println("saved");

        System.out.println(lastTask.getProjectName() + " " + lastTask.getTaskName() + " finished" + lastTask.getStop());
        System.out.println("Duration: " + Duration.between(lastTask.getStop(),lastTask.getStart()));

    }

    public Task getCurrent() throws FileNotFoundException {
        Task task = taskDao.getAll()
                .get(taskDao.getAll().size() - 1);

        System.out.println(task);

        if (task.getStop() != null) {
            System.out.println("No open tasks");
        }

        return task;
    }


    public void printAll() throws FileNotFoundException {

        taskDao.getAll().forEach(System.out::println);


    }
}
