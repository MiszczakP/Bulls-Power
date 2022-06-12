package service;

import adapter.FileInterpreter;
import model.TaskDao;

import java.io.FileNotFoundException;
import java.util.Arrays;


public class InputReader {


    String function;
    String[] arguments;


    public InputReader(String function, String[]arguments) throws FileNotFoundException {
        this.function = function;
        this.arguments = arguments;
    }

    TaskService taskService = new TaskService(new TaskDao(new FileInterpreter()));

    public void run () throws FileNotFoundException {


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
                taskService.printCurrent();
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
    private static void showHelp () {

        String[] commands = {"start", "stop", "report", "continue", "list", "last", "current", "-h", "-f"};
        System.out.println("Lista dostępnych komend:");
        for (String s : commands) {
            System.out.println(s);
        }
    }

}
