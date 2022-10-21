import java.awt.font.NumericShaper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke { //the duke class that runs the textbot program
    public static void runProgram() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>();
        Parser parser = new Parser(taskList);
        boolean active = true;
        greetUser();
        while (active) {
            System.out.println("_________________________");
            String s = scanner.nextLine();
            try {
                parser.parse(s);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Number is too big!");
            } catch (InsufficientArgumentsException e) {
                System.out.println("Incomplete command!");
            } catch (NumberFormatException e) {
                System.out.println("Unrecognized Command!");
            } catch (IOException e) { //this block should never be reached, how do I get rid of this?
                System.out.println("heh");
            }
        }
    }
    public static void greetUser() {
        String logo = "\n __ _________    _____   ____   _____  \n" +
                "|  |  \\_  __ \\  /     \\ /  _ \\ /     \\ \n" +
                "|  |  /|  | \\/ |  Y Y  (  <_> )  Y Y  \\\n" +
                "|____/ |__|    |__|_|  /\\____/|__|_|  /\n";
        System.out.println(logo);
        System.out.println("Hi! This is duke.");
    }
}