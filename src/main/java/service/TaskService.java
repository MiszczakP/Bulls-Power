package service;

import model.Task;
import model.TaskDao;

import java.util.List;

public class TaskService {

    private final TaskDao taskDao;
    private final List<Task> tasks;

    public TaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
        tasks = taskDao.getAll();
    }

    public void start(String projectName, String taskName) {

        if (!tasks.isEmpty()) {
            Task lastTask = tasks.get(taskDao.getAll().size() - 1);

            if (lastTask.getStop() == null) {
                lastTask.finishTask();
            }
        }

        Task task = new Task(projectName, taskName);
        tasks.add(new Task(projectName, taskName));

        taskDao.save(tasks);

        System.out.println(projectName + " " + taskName + " started at:" + task.getStart());

    }

    public void stop() {

        Task lastTask = tasks.get(taskDao.getAll().size() - 1);
        lastTask.finishTask();

        taskDao.save(tasks);

        System.out.println(lastTask.getProjectName() + " " + lastTask.getTaskName() + " finished at:" + lastTask.getStop());
        System.out.println("Duration: " + lastTask.getDuration());

    }

    public void printCurrent() {
        Task task = taskDao.getCurrent();
        if (!task.getStop().isEmpty()) {
            System.out.println("No open tasks");
        } else {
            System.out.println(task);
        }

    }

    public List<Task> getAll() {
        return tasks;
    }

    public void printLast() {
        List<Task> tasks = taskDao.getLastNineTasks();
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ": " + tasks.get(i));
        }
    }

    public void continueTask() {
        continueTaskWithId(1);
    }

    public void continueTaskWithId(int taskId) {
        start(taskDao.continueTask(taskId).getProjectName(), taskDao.continueTask(taskId).getTaskName());
    }
}