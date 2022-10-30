import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class Parser { //the class that takes in input Strings by the user

    public Parser() {

    }
    public int parse(String cmd) throws InsufficientArgumentsException, IOException {
        String[] split = cmd.split(" ", 2);
        String commandType = split[0].trim();
        String commandDetails = "";
        if (split.length > 1) commandDetails = split[1].trim();
        if (cmd.trim().equals("")) return 0;
        else if (isBye(cmd)) {
            return 1;
        }
        else if (isShowList(cmd)) {
            return 3;
        }
        else if (isFind(commandType)) {
            return 6;
        }
        else if (isAddTask(commandType)) {
            return 2;
        } else if (isMarkTask(commandType)) {
            return 4;
        } else if (isDeleteTask(commandType)) {
            return 5;
        } else {
            return 0;
        }
    }
    //do nothing: 0, bye: 1, addTask: 2, showList: 3, markUnmarkTask: 4, delete: 5, find: 6
    public static boolean isBye(String str) {
        return str.equals("bye");
    }
    public static boolean isAddTask(String str) {
        return str.equals("todo") || str.equals("deadline") || str.equals("event");
    }
    public static boolean isShowList(String str) {
        return str.substring(0, 4).equals("list");
    }

    public static boolean isMarkTask(String str) {
        return str.equals("mark") || str.equals("unmark");
    }

    public static boolean isDeleteTask(String str) {
        return str.equals("delete");
    }
    public static boolean isFind(String str) {
        return str.equals("find");
    }
}