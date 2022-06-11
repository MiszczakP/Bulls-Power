package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    Helper helper = new Helper();

    public void start(String projectName, String taskName) {
        Task task = new Task(projectName, taskName);

        List<Task> all = helper.getAll();
        Task lastTask = all.get(all.size() - 1);

        if (lastTask.getStop() == null) {
            lastTask.setStop(LocalDateTime.now());
        }

        all.add(new Task(projectName, taskName));

        helper.save(all);



    }

    public void stop() {

        List<Task> all = helper.getAll();
        Task lastTask = all.get(all.size() - 1);
        lastTask.setStop(LocalDateTime.now());

        helper.save(all);

    }



}
