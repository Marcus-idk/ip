import java.util.ArrayList;
import java.util.Scanner;

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
    public void divider() {
        System.out.println("_________________________");
    }
    public void byeUser() {
        System.out.println("Bye");
    }
    public void showList(TaskList list) {
        if (list.size() == 0) {
            System.out.println("Your list is empty!");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + "." + list.get(i).getDescription());
            }
        }
    }
    public void doNothing() {
        System.out.println("Did you mean to do anything?");
    }
}
