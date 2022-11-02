import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.ToDo;
import duke.tasks.Task;
public class Parser { //the class that takes in input Strings by the user
    public Parser() {
    }
    public Command parse(String cmd) throws InsufficientArgumentsException, IOException, UnrecognizedCommandException {
        String[] split = cmd.split(" ", 2);
        String commandType = split[0].trim();
        String commandDetails = "";
        if (split.length > 1) commandDetails = split[1].trim();
        if (cmd.trim().equals("")) return new Command(0, commandDetails);
        else if (isBye(commandType)) {
            return new Command(1, commandDetails);
        }
        else if (isShowList(commandType)) {
            return new Command(3, commandDetails);
        }
        else if (isFind(commandType)) {
            return new Command(7, commandDetails);
        } else if (isAddTask(commandType)) {
            if (isToDo(commandType)) return new Command(21, commandDetails);
            else if (isDeadline(commandType)) return new Command(22, commandDetails);
            else if (isEvent(commandType)) return new Command(23, commandDetails);
            else throw new UnrecognizedCommandException();
        } else if (isMarkTask(commandType)) {
            return new Command(4, commandDetails);
        } else if (isUnMarkTask(commandType)) {
            return new Command(5, commandDetails);
        } else if (isDeleteTask(commandType)) {
            return new Command(6, commandDetails);
        } else {
            return new Command(0, commandDetails);
        }
    }
    //do nothing: 0, bye: 1, addTask: 2, showList: 3, markTask: 4, unMarkTask: 5, delete: 6, find: 7
    public static boolean isBye(String str) {
        return str.equals("bye");
    }
    public static boolean isAddTask(String str) {
        return str.equals("todo") || str.equals("deadline") || str.equals("event");
    }
    public static boolean isToDo(String str) { return str.equals("todo"); }
    public static boolean isDeadline(String str) { return str.equals("deadline"); }
    public static boolean isEvent(String str) { return str.equals("event"); }
    public static boolean isShowList(String str) {
        return str.substring(0, 4).equals("list");
    }
    public static boolean isMarkTask(String str) {
        return str.equals("mark");
    }
    public static boolean isUnMarkTask(String str) { return str.equals("unmark"); }
    public static boolean isDeleteTask(String str) {
        return str.equals("delete");
    }
    public static boolean isFind(String str) {
        return str.equals("find");
    }
}