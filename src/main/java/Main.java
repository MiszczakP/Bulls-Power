

import adapter.FileInterpreter;
import model.TaskDao;
import service.TaskService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        String function = args[0];
        String[] arguments = Arrays.copyOfRange(args, 1, args.length);

        TaskService taskService = new TaskService(new TaskDao(new FileInterpreter()));

        if (args.length != 0) {

            switch (function) {

                case "start":
                    taskService.start(arguments[0], arguments[1]);
                    break;
                case "stop":
                    taskService.stop();
                    break;
                case "continue":
                    //TODO
                    break;
                case "current":
                    taskService.getCurrent();
                    break;
                case "report":
                    //TODO
                    break;
                case "list":
                    taskService.printAll();
                    break;
                case "last":
                    //TODO
                    break;
                case "-h":
                    showHelp();
                    break;
                case "-f":
                    break;
            }
        }

    }

    private static void showHelp() {

        String[] commands = {"start", "stop", "report", "continue", "list", "last", "current", "-h", "-f"};
        System.out.println("Lista dostępnych komend:");
        for (String s: commands) {
            System.out.println(s);
        }
    }
}

