import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>();
        boolean active = true;
        greetUser();
        while (active) {
            try {
                String s = scanner.nextLine();
                String[] splitBySpace = s.split(" ");
                if (s.trim().equals("bye")) {
                    byeUser();
                    active = false;
                } else {
                    if (splitBySpace[0].equals("mark")) {
                        int index = Integer.parseInt(splitBySpace[1]);
                        markTask(index, taskList);
                    } else if (splitBySpace[0].equals("unmark")) {
                        int index = Integer.parseInt(splitBySpace[1]);
                        unMarkTask(index, taskList);
                    } else if (s.trim().equals("list")) {
                        printTaskList(taskList);
                    } else if (splitBySpace[0].equals("delete")) {
                        deleteTask(splitBySpace[1], taskList);
                    } else {
                        addToTaskList(s, taskList);
                    }
                }
            } catch (DukeNotEnoughInfo | ArrayIndexOutOfBoundsException e) {
                System.out.println("_________________________");
                System.out.println("Command is incomplete / unrecognized");
                System.out.println("_________________________");
            } catch (NumberFormatException e) {
                System.out.println("_________________________");
                System.out.println("Your command must come with an index");
                System.out.println("_________________________");
            } catch (markIndexOutOfBoundsException | deleteIndexOutOfBoundsException e) {
                System.out.println("_________________________");
                System.out.println(e.getMessage());
                System.out.println("_________________________");
            }
        }
    }
    public static void greetUser() {
        String logo = "\n __ _________    _____   ____   _____  \n" +
                "|  |  \\_  __ \\  /     \\ /  _ \\ /     \\ \n" +   
                "|  |  /|  | \\/ |  Y Y  (  <_> )  Y Y  \\\n" +
                "|____/ |__|    |__|_|  /\\____/|__|_|  /\n";
        System.out.println(logo);
        System.out.println("_________________________");
        System.out.println("Hello dawg my names Donald duck, whatchu wanna do");
        System.out.println("_________________________");
    }
    public static void echoUser(String str) {
        System.out.println("_________________________");
        System.out.println("oh, so u wanna do " + str);
        System.out.println("_________________________");
    }
    public static void byeUser() {
        System.out.println("_________________________");
        System.out.println("Bye loser");
        System.out.println("_________________________");
    }
    public static void addToTaskList(String str, ArrayList<Task> list) throws DukeNotEnoughInfo, ArrayIndexOutOfBoundsException {
        String[] splitBySpace = str.split(" ");
        String typeOfTask = splitBySpace[0];
        Task task;
        if (typeOfTask.equals("todo")) {
            String nameOfTask = str.substring(5, str.length());
            task = new toDos(nameOfTask);
            list.add(task);
        } else {
            String[] splitBySlash = str.split("/");
            int lengthAfterSlash = splitBySlash[1].length();
            String taskDateInfo = editDeadlineForTasks(str.substring(str.length() - lengthAfterSlash - 1, str.length()));
            if (typeOfTask.equals("deadline")) {
                String taskName = str.substring(9, str.length() - lengthAfterSlash - 2);
                task = new Deadlines(taskName, taskDateInfo);
                list.add(task);
            } else {
                String taskName = str.substring(6, str.length() - lengthAfterSlash - 2);
                task = new Events(taskName, taskDateInfo);
                list.add(task);
            }
        }
        System.out.println("_________________________");
        System.out.println("Aight. I will add dis to the list homie.");
        System.out.println("   " + task.getDescription());
        System.out.println("Lmao, now u have " + list.size() + " tasks");
        System.out.println("_________________________");
    }
    public static void printTaskList(ArrayList<Task> list) {
        System.out.println("_________________________");
        if (list.size() == 0) {
            System.out.println("Ur list's empty lmao");
        } else {
            System.out.println("Take a look at ur list dawg");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + "." + list.get(i).getDescription());
            }
        }
        System.out.println("_________________________");
    }
    public static void markTask(int index, ArrayList<Task> list) throws markIndexOutOfBoundsException {
        try {
            list.get(index).markTask();
            System.out.println("_________________________");
            System.out.println("wah finally done with [X] " + list.get(index).getName());
            System.out.println("_________________________");
        } catch (IndexOutOfBoundsException e){
            throw new markIndexOutOfBoundsException("Your mark command index does not exist yet bro");
        }
    }
    public static void unMarkTask(int index, ArrayList<Task> list) {
        list.get(index).unMarkTask();
        System.out.println("_________________________");
        System.out.println("why dahell u unmark [ ] " + list.get(index).getName());
        System.out.println("_________________________");
    }
    public static String editDeadlineForTasks(String str) {
        String[] split = str.split(" ");
        String result = split[0] + ": ";
        result = result.replace("/", "");
        for (int i = 1; i < split.length; i++) {
            result = result + split[i];
        }
        return "(" + result + ")";
    }
    public static void deleteTask(String str, ArrayList<Task> list) throws deleteIndexOutOfBoundsException, NumberFormatException {
        int index = Integer.parseInt(str);
        if (index >= list.size() || index < 0) {
            throw new deleteIndexOutOfBoundsException("Delete index is out of bounds");
        } else {
            String s = list.get(index).getDescription();
            list.remove(index);
            System.out.println("_________________________");
            System.out.println("why dahell u delete " + s);
            System.out.println("Theres " + list.size() + " tasks left LOL");
            System.out.println("_________________________");
        }
    }
}