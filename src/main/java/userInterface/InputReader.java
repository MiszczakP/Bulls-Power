package userInterface;

import adapter.FileInterpreter;
import model.TaskDao;
import service.HelpService;
import service.Printer;
import service.TaskService;

import java.io.FileNotFoundException;


public class InputReader {


    String function;
    String[] arguments;


    public InputReader(String function, String[] arguments) {
        this.function = function;
        this.arguments = arguments;
    }

    HelpService helpService = new HelpService();
    TaskService taskService = new TaskService(new TaskDao(new FileInterpreter()));
    Printer printer = new Printer();

    public void run() {


        switch (function) {

            case "start":
                taskService.start(arguments[0], arguments[1]);
                break;
            case "stop":
                taskService.stop();
                break;
            case "continue":
                taskService.continueTask();
                break;
            case "current":
                taskService.printCurrent();
                break;
            case "report":
                //TODO
                break;
            case "list":
                taskService.printAll();
                break;
            case "last":
                taskService.printLast();
                break;
            case "-h":
                helpService.printHelp();
                break;
            case "-f":
                printer.printTasks();
                break;
        }


    }

    private static void showHelp() {

        String[] commands = {"start", "stop", "report", "continue", "list", "last", "current", "-h", "-f"};
        System.out.println("Lista dostępnych komend:");
        for (String s : commands) {
            System.out.println(s);
        }
    }

}
