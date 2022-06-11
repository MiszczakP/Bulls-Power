package model;

import adapter.FileInterpreter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TaskDao {

    private FileInterpreter fileInterpreter;
    private List<Task> tasks;

    public TaskDao(FileInterpreter interpreter) throws FileNotFoundException {
        fileInterpreter = interpreter;
        tasks = fileInterpreter.readDocumentsInDataFolder();
    }

    public List<Task> getAll() {
        return tasks;
    }

    public void save(List<Task> tasks) throws IOException {
        fileInterpreter.saveDataToDocument(tasks);
    }


}
