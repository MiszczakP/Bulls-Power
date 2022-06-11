package model;

import adapter.FileInterpreter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
