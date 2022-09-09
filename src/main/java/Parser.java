import java.lang.reflect.Array;
import java.util.ArrayList;

public class Parser {
    private ArrayList<Task> arr;
    public Parser(ArrayList<Task> arr) {
        this.arr = arr;
    }
    public void parse(String cmd) {
        if (isBye(cmd)) {
            byeUser();
            System.exit(0);
        }
        if (isShowList(cmd)) {
            showList(arr);
            return;
        }
        String[] split = cmd.split(" ", 2);
        String commandType = split[0];
        String commandDetails = split[1];
        if (isAddTask(commandType)) {
            addToTaskList(commandType, commandDetails, arr);
        } else if (isMarkTask(commandType)) {
            markUnMarkTask(commandType, commandDetails, arr);
        } else if (isDeleteTask(commandType)) {
            deleteTask(commandDetails, arr);
        }
    }





    public static boolean isBye(String str) {
        return str.trim().equals("bye");
    }
    public static void byeUser() {
        System.out.println("_________________________");
        System.out.println("Bye");
        System.out.println("_________________________");
    }
    public static boolean isAddTask(String str) {
        String strTrim = str.trim();
        return strTrim.equals("todo") || strTrim.equals("deadline") || strTrim.equals("event");
    }
    public static void addToTaskList(String type, String details, ArrayList<Task> list) {
        String typeOfTask = type;
        Task task;
        if (typeOfTask.equals("todo")) {
            task = new toDos(details);
            list.add(task);
        } else {
            String[] splitBySlash = details.split("/", 2);
            String taskName = splitBySlash[0].trim();
            String taskDate = splitBySlash[1].trim();
            taskDate = editDateString(taskDate);
            if (typeOfTask.equals("deadline")) {
                task = new Deadlines(taskName, taskDate);
                list.add(task);
            } else {
                task = new Events(taskName, taskDate);
                list.add(task);
            }
        }
        System.out.println("_________________________");
        System.out.println("Added to the list!");
        System.out.println("   " + task.getDescription());
        System.out.println("You now have " + list.size() + " tasks");
        System.out.println("_________________________");
    }
    public static String editDateString(String str) {
        String[] splitByDot = str.split(" ", 2);
        return "(" + splitByDot[0] + ": " + splitByDot[1] + ")";
    }
    public static boolean isShowList(String str) {
        return str.trim().equals("list");
    }
    public static void showList(ArrayList<Task> list) {
        System.out.println("_________________________");
        if (list.size() == 0) {
            System.out.println("Your list is empty!");
        } else {
            System.out.println("Ur list:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + "." + list.get(i).getDescription());
            }
        }
        System.out.println("_________________________");
    }
    public static boolean isMarkTask(String str) {
        String strTrim = str.trim();
        return strTrim.equals("mark") || strTrim.equals("unmark");
    }
    public static void markUnMarkTask(String type, String details, ArrayList<Task> list) {
        if (type.equals("mark")) {
            markTask(Integer.parseInt(details), list);
        } else {
            unMarkTask(Integer.parseInt(details), list);
        }
    }
    public static void markTask(int index, ArrayList<Task> list) {
        list.get(index).markTask();
        System.out.println("_________________________");
        System.out.println("Marking [X] " + list.get(index).getName());
        System.out.println("_________________________");
    }
    public static void unMarkTask(int index, ArrayList<Task> list) {
        list.get(index).unMarkTask();
        System.out.println("_________________________");
        System.out.println("Unmarking [ ] " + list.get(index).getName());
        System.out.println("_________________________");
    }
    public static boolean isDeleteTask(String str) {
        return str.trim().equals("delete");
    }
    public static void deleteTask(String details, ArrayList<Task> list) {
        int index = Integer.parseInt(details);
        String s = list.get(index).getDescription();
        list.remove(index);
        System.out.println("_________________________");
        System.out.println("Deleting " + s);
        System.out.println("Theres " + list.size() + " task(s) left");
        System.out.println("_________________________");
    }
}