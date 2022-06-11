package model;

import adapter.FileInterpreter;

import java.util.List;

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


}
