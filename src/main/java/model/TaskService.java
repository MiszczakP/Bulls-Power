package model;

public class TaskService {



    public void start(String projectName, String taskName) {
        new Task(projectName, taskName);
    }

    public void stop() {
        
    }

}
