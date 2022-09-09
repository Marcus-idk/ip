import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void runProgram() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>();
        Parser parser = new Parser(taskList);
        boolean active = true;
        greetUser();
        while (active) {
            String s = scanner.nextLine();
            parser.parse(s);
        }
    }
    public static void greetUser() {
        String logo = "\n __ _________    _____   ____   _____  \n" +
                "|  |  \\_  __ \\  /     \\ /  _ \\ /     \\ \n" +
                "|  |  /|  | \\/ |  Y Y  (  <_> )  Y Y  \\\n" +
                "|____/ |__|    |__|_|  /\\____/|__|_|  /\n";
        System.out.println(logo);
        System.out.println("_________________________");
        System.out.println("Hi! This is duke.");
        System.out.println("_________________________");
    }
}