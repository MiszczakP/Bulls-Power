package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Helper {

    public List<Task> getAll() {

        List<Task> tasks = new ArrayList<>();
        Task task1 = new Task("a", "b", LocalDateTime.now(), LocalDateTime.now());
        Task task2 = new Task("c", "d");

        tasks.add(task1);
        tasks.add(task2);

        return tasks;
    }

    public void save(List<Task> tasks) {
        System.out.println("saved");
    }

}
