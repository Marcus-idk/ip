import java.io.IOException;

public class Parser { //the class that takes in input Strings by the user
    public Parser() {
    }
    public Command parse(String cmd) throws InsufficientArgumentsException, IOException, UnrecognizedCommandException {
        String[] split = cmd.split(" ", 2);
        String commandType = split[0].trim();
        String commandDetails = "";
        if (split.length > 1) commandDetails = split[1].trim();
        if (cmd.trim().equals("")) return new Command(typeOfCommand.doNothing, commandDetails);
        else if (isBye(commandType)) {
            return new Command(typeOfCommand.bye, commandDetails);
        }
        else if (isShowList(commandType)) {
            return new Command(typeOfCommand.showList, commandDetails);
        }
        else if (isFind(commandType)) {
            return new Command(typeOfCommand.find, commandDetails);
        } else if (isAddTask(commandType)) {
            if (isToDo(commandType)) return new Command(typeOfCommand.addToDo, commandDetails);
            else if (isDeadline(commandType)) return new Command(typeOfCommand.addDeadline, commandDetails);
            else if (isEvent(commandType)) return new Command(typeOfCommand.addEvent, commandDetails);
            else throw new UnrecognizedCommandException();
        } else if (isMarkTask(commandType)) {
            return new Command(typeOfCommand.markTask, commandDetails);
        } else if (isUnMarkTask(commandType)) {
            return new Command(typeOfCommand.unMarkTask, commandDetails);
        } else if (isDeleteTask(commandType)) {
            return new Command(typeOfCommand.delete, commandDetails);
        } else {
            return new Command(typeOfCommand.doNothing, commandDetails);
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