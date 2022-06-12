package model;

import adapter.FileInterpreter;

import java.util.List;
import java.util.stream.Collectors;

public class TaskDao {

    private final FileInterpreter fileInterpreter;
    private final List<Task> tasks;

    public TaskDao(FileInterpreter interpreter) {
        fileInterpreter = interpreter;
        tasks = fileInterpreter.readDocumentsInDataFolder();
    }

    public List<Task> getAll() {
        return tasks;
    }

    public void save(List<Task> tasks) {
        fileInterpreter.saveDataToDocument(tasks);
    }

    public List<Task> getTasksByProject(String projectName) {
        return tasks.stream().filter(e -> e.getProjectName().equals(projectName)).collect(Collectors.toList());
    }

    public void printTasksByProject(String projectName) {
        for (Task a : getTasksByProject(projectName)) {
            System.out.println(a.getTaskName());
            System.out.println(a.getStop().getDay());
        }
    }


}
