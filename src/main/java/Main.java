
import adapter.FileInterpreter;
import model.Task;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        FileInterpreter fileInterpreter = new FileInterpreter();

        List<Task> tasks = fileInterpreter.readDocumentsInDataFolder();

    }

}
