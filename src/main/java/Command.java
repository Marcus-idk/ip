import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.ToDo;
import duke.tasks.Task;

import java.io.IOException;

public class Command {
    private typeOfCommand commandType;
    private String commandDetails;
    public Command(typeOfCommand commandType, String commandDetails) {
        this.commandType = commandType;
        this.commandDetails = commandDetails;
    }
    public void execute(TaskList arr, UI ui, Storage storage) throws InsufficientArgumentsException, IOException {
        if (commandType == typeOfCommand.doNothing) { //do nothing
            ui.doNothing();
            return;
        } else if (commandType == typeOfCommand.bye) { //stop the program
            ui.byeUser();
            return;
        }
        String type = commandDetails.split(" ", 2)[0];
        if (commandType == typeOfCommand.addToDo) {
            addToTaskList("todo", commandDetails, arr, ui);
            storage.save(arr);
        } else if (commandType == typeOfCommand.addDeadline) {
            addToTaskList("deadline", commandDetails, arr, ui);
            storage.save(arr);
        } else if (commandType == typeOfCommand.addEvent) {
            addToTaskList("event", commandDetails, arr, ui);
            storage.save(arr);
        } else if (commandType == typeOfCommand.showList) {
            ui.showList(arr);
        } else if (commandType == typeOfCommand.markTask) {
            int index = Integer.parseInt(commandDetails);
            markTask(index, arr, ui);
            storage.save(arr);
        } else if (commandType == typeOfCommand.unMarkTask) {
            int index = Integer.parseInt(commandDetails);
            unMarkTask(index, arr, ui);
            storage.save(arr);
        } else if (commandType == typeOfCommand.delete) {
            deleteTask(commandDetails, arr, ui);
            storage.save(arr);
        } else if (commandType == typeOfCommand.find) {
            find(arr, commandDetails, ui);
        }
    }
    public void addToTaskList(String type, String details, TaskList list, UI ui) throws InsufficientArgumentsException, IndexOutOfBoundsException {
        if (details.equals("")) {
            throw new InsufficientArgumentsException();
        }
        String typeOfTask = type;
        Task task;
        if (typeOfTask.equals("todo")) {
            task = new ToDo(details);
            list.add(task);
        } else {
            String[] splitBySlash = details.split("/", 2);
            String taskName = splitBySlash[0].trim();
            String taskDate = splitBySlash[1].trim();
            if (typeOfTask.equals("deadline")) {
                task = new Deadline(taskName, taskDate);
                list.add(task);
            } else {
                task = new Event(taskName, taskDate);
                list.add(task);
            }
        }
        ui.addToList(task, list);
    }
    public String editDateString(String str) {
        String[] splitByDot = str.split(" ", 2);
        return "(" + splitByDot[0] + ": " + splitByDot[1] + ")";
    }
    public static void markTask(int index, TaskList list, UI ui) {
        list.get(index - 1).markTask();
        ui.markTask(index - 1, list);
    }
    public static void unMarkTask(int index, TaskList list, UI ui) {
        list.get(index - 1).unMarkTask();
        ui.unMarkTask(index - 1, list);
    }
    public static void deleteTask(String details, TaskList list, UI ui) throws InsufficientArgumentsException, NumberFormatException {
        if (details.equals("")) {
            throw new InsufficientArgumentsException();
        }
        int index = Integer.parseInt(details);
        String s = list.get(index - 1).getDescription();
        list.remove(index - 1);
        ui.deleteTask(index, list);
    }
    public static void find(TaskList arr, String str, UI ui) throws InsufficientArgumentsException {
        if (str.equals("")) throw new InsufficientArgumentsException();
        int counter = 1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getName().contains(str)) {
                ui.printCustomList(counter, i, arr);
                counter++;
            }
        }
        if (counter == 1) { ui.cannotFind(); ui.divider(); }
    }
}