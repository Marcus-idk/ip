import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class Parser { //the class that takes in input Strings by the user
    private ArrayList<Task> arr;
    public Parser(ArrayList<Task> arr) {
        this.arr = arr;
    }
    public void parse(String cmd) throws InsufficientArgumentsException, IOException{
        if (isBye(cmd)) {
            byeUser();
            System.exit(0);
        }
        if (isShowList(cmd)) {
            showList(arr);
            return;
        }
        String[] split = cmd.split(" ", 2);
        String commandType = split[0].trim();
        String commandDetails = "";
        if (split.length > 1) commandDetails = split[1].trim();
        if (isAddTask(commandType)) {
            addToTaskList(commandType, commandDetails, arr);
        } else if (isMarkTask(commandType)) {
            markUnMarkTask(commandType, commandDetails, arr);
        } else if (isDeleteTask(commandType)) {
            deleteTask(commandDetails, arr);
        } else if (isSave(commandType)) {
            save(arr);
        } else {
            System.out.println("Did you mean to do anything? UNRECOGNIZED COMMAND");
        }
    }





    public static boolean isBye(String str) {
        return str.equals("bye");
    }
    public static void byeUser() {
        System.out.println("Bye");
    }
    public static boolean isAddTask(String str) {
        return str.equals("todo") || str.equals("deadline") || str.equals("event");
    }
    public static void addToTaskList(String type, String details, ArrayList<Task> list) throws InsufficientArgumentsException {
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
            taskDate = editDateString(taskDate);
            if (typeOfTask.equals("deadline")) {
                task = new Deadline(taskName, taskDate);
                list.add(task);
            } else {
                task = new Event(taskName, taskDate);
                list.add(task);
            }
        }
        System.out.println("Added to the list!");
        System.out.println("   " + task.getDescription());
        System.out.println("You now have " + list.size() + " tasks");
    }
    public static String editDateString(String str) {
        String[] splitByDot = str.split(" ", 2);
        return "(" + splitByDot[0] + ": " + splitByDot[1] + ")";
    }
    public static boolean isShowList(String str) {
        return str.substring(0, 4).equals("list");
    }
    public static void showList(ArrayList<Task> list) {
        if (list.size() == 0) {
            System.out.println("Your list is empty!");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + "." + list.get(i).getDescription());
            }
        }
    }
    public static boolean isMarkTask(String str) {
        return str.equals("mark") || str.equals("unmark");
    }
    public static void markUnMarkTask(String type, String details, ArrayList<Task> list) throws InsufficientArgumentsException {
        if (details.equals("")) {
            throw new InsufficientArgumentsException();
        }
        if (type.equals("mark")) {
            markTask(Integer.parseInt(details), list);
        } else {
            unMarkTask(Integer.parseInt(details), list);
        }
    }
    public static void markTask(int index, ArrayList<Task> list) {
        list.get(index - 1).markTask();
        System.out.println("Marking [X] " + list.get(index - 1).getName());
    }
    public static void unMarkTask(int index, ArrayList<Task> list) {
        list.get(index - 1).unMarkTask();
        System.out.println("Unmarking [ ] " + list.get(index - 1).getName());
    }
    public static boolean isDeleteTask(String str) {
        return str.equals("delete");
    }
    public static void deleteTask(String details, ArrayList<Task> list) throws InsufficientArgumentsException, NumberFormatException {
        if (details.equals("")) {
            throw new InsufficientArgumentsException();
        }
        int index = Integer.parseInt(details);
        String s = list.get(index).getDescription();
        list.remove(index);
        System.out.println("Deleting " + s);
        System.out.println("Theres " + list.size() + " task(s) left");
    }
    public static boolean isSave(String str) {
        return str.equals("save");
    }
    public static void save(ArrayList<Task> arr) throws IOException { //index, name, marked, type of task
        FileWriter myWriter = new FileWriter("C:\\Users\\Marcus\\IdeaProjects\\ip\\dukeSaveFile.txt");
        for (int i = 0; i < arr.size(); i++) {
            myWriter.write((i + 1) + ", " + arr.get(i).getName() + ", " + arr.get(i).isMarked() + ", " + arr.get(i).getType() + "\n");
        }
        myWriter.close();
        System.out.println("Save Successful!");
    }
}