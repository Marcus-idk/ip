package duke.parser;
import duke.InsufficientArgumentsException;
import duke.UnrecognizedCommandException;
import duke.commands.*;
import duke.parser.*;

import java.io.IOException;
public class Parser { //the class that takes in input Strings by the user
    public Parser() {
    }
    public Command parse(String cmd) throws InsufficientArgumentsException, IOException, UnrecognizedCommandException {
        String[] split = cmd.split(" ", 2);
        String commandType = split[0].trim();
        String commandDetails = "";
        if (split.length > 1) commandDetails = split[1].trim();
        if (cmd.trim().equals("")) return new DoNothingCommand();
        else if (isBye(commandType)) {
            return new ByeCommand();
        }
        else if (isShowList(commandType)) {
            return new ShowListCommand();
        }
        else if (isFind(commandType)) {
            return new FindCommand();
        } else if (isAddTask(commandType)) {
            if (isToDo(commandType)) {
                AddToDoParser p = new AddToDoParser();
                p.getData(commandDetails);
                return new AddToDoCommand(p.getName());
            }
            else if (isDeadline(commandType)) {
                AddDeadlineParser p = new AddDeadlineParser();
                p.getData(commandDetails);
                return new AddDeadlineCommand(p.getName(), p.getDeadline());
            }
            else if (isEvent(commandType)) {
                AddEventParser p = new AddEventParser();
                p.getData(commandDetails);
                return new AddEventCommand(p.getName(), p.getStartTime(), p.getEndTime());
            }
            else throw new UnrecognizedCommandException();
        } else if (isMarkTask(commandType)) {
            MarkTaskParser p = new MarkTaskParser();
            p.getData(commandDetails);
            return new MarkTaskCommand(p.getIndex());
        } else if (isUnMarkTask(commandType)) {
            UnMarkTaskParser p = new UnMarkTaskParser();
            p.getData(commandDetails);
            return new UnMarkTaskCommand(p.getIndex());
        } else if (isDeleteTask(commandType)) {
            DeleteParser p = new DeleteParser();
            p.getData(commandDetails);
            return new DeleteTaskCommand(p.getIndex());
        } else {
            return new DoNothingCommand();
        }
    }
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