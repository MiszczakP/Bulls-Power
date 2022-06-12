package userInterface;

import adapter.FileInterpreter;
import model.Task;
import model.TaskDao;
import report.ReportCreator;
import service.HelpService;
import service.Printer;
import service.TaskService;

import java.io.FileNotFoundException;

public class Starter {

    private String function;
    private String[] arguments;
    private HelpService helpService = new HelpService();
    private TaskService taskService = new TaskService(new TaskDao(new FileInterpreter()));
    private Printer printer = new Printer();
    ReportCreator reportCreator = new ReportCreator();

    public Starter(String function, String[] arguments) {
        this.function = function;
        this.arguments = arguments;
    }

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


}
