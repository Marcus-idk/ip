package duke;
import java.util.ArrayList;
import java.util.Scanner;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.ToDo;
import duke.tasks.Task;
public class UI {
    private Scanner scanner;
    public UI() {
        scanner = new Scanner(System.in);
    }
    public String readCommand() {
        String s = scanner.nextLine();
        return s;
    }
    public void greetUser() {
        String logo = "\n __ _________    _____   ____   _____  \n" +
                "|  |  \\_  __ \\  /     \\ /  _ \\ /     \\ \n" +
                "|  |  /|  | \\/ |  Y Y  (  <_> )  Y Y  \\\n" +
                "|____/ |__|    |__|_|  /\\____/|__|_|  /\n";
        System.out.println(logo);
        System.out.println("Hi! This is duke.");
    }
    public void fileNotFound() {
        System.out.println("File not found!");
        divider();
    }
    public void divider() {
        System.out.println("_________________________");
    }
    public void byeUser() {
        System.out.println("Bye!!!?!?!???!");
    }
    public void showList(TaskList list) {
        if (list.size() == 0) {
            System.out.println("Your list is empty!");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + "." + list.get(i).getDescription());
            }
        }
        divider();
    }
    public void printCustomList(int display, int index, TaskList list) {
        System.out.println(display + ". " + list.get(index).getDescription());
        divider();
    }
    public void cannotFind() {
        System.out.println("Unable to find anything, maybe change your keywords?");
    }
    public void addToList(Task task, TaskList list) {
        System.out.println("Added to the list!");
        System.out.println("   " + task.getDescription());
        System.out.println("You now have " + list.size() + " tasks");
        divider();
    }
    public void markTask(int index, TaskList list) {
        System.out.println("Marking [X] " + list.get(index).getName());
        divider();
    }
    public void unMarkTask(int index, TaskList list) {
        System.out.println("Unmarking [ ] " + list.get(index).getName());
        divider();
    }
    public void deleteTask(int index, TaskList list) {
        System.out.println("Deleting " + index);
        System.out.println("Theres " + list.size() + " task(s) left");
        divider();
    }
    public void doNothing() {
        System.out.println("Did you mean to do anything?");
    }
    //Exceptions
    public void indexOutOfBounds() {
        System.out.println("Input index is out of bounds");
    }
    public void or() {
        System.out.println("or");
    }
    public void incompleteCommand() {
        System.out.println("Incomplete command!");
    }
    public void unrecognizedCommand() {
        System.out.println("Unrecognized duke.commands.Command");
    }
    public void IOException() {
        System.out.println("IO Exception");
    }
}