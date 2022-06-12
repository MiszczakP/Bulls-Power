package model;

import adapter.FileInterpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskDao {

    private final FileInterpreter fileInterpreter;
    private final List<Task> tasks;
    private List<Task> lastTasks = new ArrayList<>();

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

    public Task getCurrent() {
        return tasks.get(tasks.size() - 1);
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

    public List<Task> getLastNineTasks() {
        List<Task> lastTasksUnsorted = tasks.stream().distinct().collect(Collectors.toList());
        if (!lastTasks.isEmpty()) {
            lastTasks.clear();
        }
        for (int i = lastTasksUnsorted.size() - 1; i >= 0; i--) {
            lastTasks.add(lastTasksUnsorted.get(i));
        }
        return lastTasks;
    }

    public Task continueTask() {
        return lastTasks.get(1);
    }

    public Task continueTask(int taskId) {
        lastTasks = getLastNineTasks();
        return lastTasks.get(taskId - 1);
    }
}
