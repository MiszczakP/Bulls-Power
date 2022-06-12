package userInterface;

import adapter.FileInterpreter;
import model.Task;
import model.TaskDao;
import report.ReportCreator;
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
    ReportCreator reportCreator = new ReportCreator();

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
                if(arguments[0].equals("p")){
                    printer.printReport(reportCreator.computeTime(reportCreator.filterByProjectName(taskService.getAll(), arguments[1])));
                }else if(arguments[0].equals("d")){
                    printer.printReport(reportCreator.computeTime(reportCreator.filterByDate(taskService.getAll(), arguments[1],arguments[2])));
                }else{
                    printer.printReport(reportCreator.computeTime(taskService.getAll()));
                }
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
