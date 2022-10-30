import java.util.ArrayList;

public class Command {
    private TaskList arr;
    private UI ui;
    public Command(TaskList arr, UI ui) {
        this.arr = arr;
    }
    public void execute(int x, String command) throws InsufficientArgumentsException {
        if (x == 0) { //do nothing
            ui.doNothing();
            return;
        } else if (x == 1) { //stop the program
            ui.byeUser();
            return;
        }
        String type = command.split(" ", 2)[0];
        String details = command.split(" ", 2)[1];
        if (x == 2) { //add to list
            addToTaskList(type, details, this.arr);
        } else if (x == 3) {
            ui.showList(arr);
        } else if (x == 4) {
            markUnMarkTask(type, details, this.arr);
        } else if (x == 5) {
            deleteTask(details, this.arr);
        } else {
            find(arr, details);
        }
    }
    public void addToTaskList(String type, String details, TaskList list) throws InsufficientArgumentsException {
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
        System.out.println("Added to the list!");
        System.out.println("   " + task.getDescription());
        System.out.println("You now have " + list.size() + " tasks");
    }
    public String editDateString(String str) {
        String[] splitByDot = str.split(" ", 2);
        return "(" + splitByDot[0] + ": " + splitByDot[1] + ")";
    }
    public static void markUnMarkTask(String type, String details, TaskList list) throws InsufficientArgumentsException {
        if (details.equals("")) {
            throw new InsufficientArgumentsException();
        }
        if (type.equals("mark")) {
            markTask(Integer.parseInt(details), list);
        } else {
            unMarkTask(Integer.parseInt(details), list);
        }
    }
    public static void markTask(int index, TaskList list) {
        list.get(index - 1).markTask();
        System.out.println("Marking [X] " + list.get(index - 1).getName());
    }
    public static void unMarkTask(int index, TaskList list) {
        list.get(index - 1).unMarkTask();
        System.out.println("Unmarking [ ] " + list.get(index - 1).getName());
    }
    public static void deleteTask(String details, TaskList list) throws InsufficientArgumentsException, NumberFormatException {
        if (details.equals("")) {
            throw new InsufficientArgumentsException();
        }
        int index = Integer.parseInt(details);
        String s = list.get(index - 1).getDescription();
        list.remove(index - 1);
        System.out.println("Deleting " + s);
        System.out.println("Theres " + list.size() + " task(s) left");
    }
    public static void find(TaskList arr, String str) throws InsufficientArgumentsException {
        if (str.equals("")) throw new InsufficientArgumentsException();
        int counter = 1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getName().contains(str)) {
                System.out.println(counter + ". " + arr.get(i).getDescription());
                counter++;
            }
        }
    }
}
