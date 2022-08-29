import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>();
        boolean active = true;
        greetUser(); //logo and starting text
        while (active) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            if (s.trim().equals("bye")) {
                byeUser();
                active = false;
            } else if (split[0].equals("mark")) {
                int index = Integer.parseInt(split[1]);
                markTask(index, taskList);
            } else if (split[0].equals("unmark")) {
                int index = Integer.parseInt(split[1]);
                unMarkTask(index, taskList);
            } else if (s.trim().equals("list")) {
                printTaskList(taskList);
            } else {
                echoUser(s);
                addToTaskList(s, taskList);
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
        System.out.println("Hello whatchu wanna do");
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
    public static void addToTaskList(String str, ArrayList<Task> list) {
        list.add(new Task(str));
    }
    public static void printTaskList(ArrayList<Task> list) {
        System.out.println("_________________________");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + "." + list.get(i).getDescription());
        }
        System.out.println("_________________________");
    }
    public static void markTask(int index, ArrayList<Task> list) {
        list.get(index).markTask();
        System.out.println("_________________________");
        System.out.println("wah finally done with [X] " + list.get(index).getName());
        System.out.println("_________________________");
    }
    public static void unMarkTask(int index, ArrayList<Task> list) {
        list.get(index).unMarkTask();
        System.out.println("_________________________");
        System.out.println("why dahell u unmark [ ] " + list.get(index).getName());
        System.out.println("_________________________");
    }
}
