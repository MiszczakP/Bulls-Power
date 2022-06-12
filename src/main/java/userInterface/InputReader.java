package userInterface;

import adapter.FileInterpreter;
import model.Task;
import model.TaskDao;
import report.ReportCreator;
import service.HelpService;
import service.Printer;
import service.TaskService;


import java.util.Map;



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
    ReportCreator creator = new ReportCreator();
    TaskDao taskDao = new TaskDao(new FileInterpreter());
    Map<Task, Long> time = creator.computeTime(taskDao.getAll());

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
                if (taskService.getCurrent().isPresent()) {
                    System.out.println(taskService.getCurrent().get());
                } else {
                    System.out.println("There is no open tasks");
                }
                break;
            case "report":
                //TODO
                printer.printReport(time);
                break;
            case "list":
                printer.printList(taskService.getAll());
                break;
            case "last":
                taskService.printLast();
                break;
            case "-h":
                helpService.printHelp();
                break;
            case "-f":

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
