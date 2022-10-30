import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke { //the duke class that runs the textbot program
    private Storage storage;
    private TaskList tasks;
    private UI ui;
    private Parser parser;
    private boolean active = true;
    public Duke() {
        try {
            ui = new UI();
            storage = new Storage("C:\\Users\\Marcus\\IdeaProjects\\ip\\dukeSaveFile.txt");
            tasks = new TaskList(storage.getData());
            parser = new Parser();
            this.runProgram();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public void runProgram() {
        while (active) {
            try {
                String command = ui.readCommand();
                int commandInt = parser.parse(command);
                Command c = new Command(tasks, ui);
                c.execute(commandInt, command);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Input index is out of bounds!");
            } catch (InsufficientArgumentsException e) {
                System.out.println("Incomplete command!");
            } catch (NumberFormatException e) {
                System.out.println("Unrecognized Command!");
            } catch (IOException e) { //this block should never be reached, how do I get rid of this?
                System.out.println("heh");
            }
        }
    }
    public static ArrayList<Task> getDataFromHardDisk() throws FileNotFoundException {
        ArrayList<Task> arr = new ArrayList<>();
        File data = new File("C:\\Users\\Marcus\\IdeaProjects\\ip\\dukeSaveFile.txt");
        Scanner reader = new Scanner(data);
        int counter = 0;
        while (reader.hasNextLine()) {
            String dataString = reader.nextLine();
            String[] split = dataString.split(",");
            String name = split[1];
            String isMarked = split[2];
            String type = split[3];
            String additionalInfo = "";
            if (split.length > 4) additionalInfo = split[4];
            System.out.println("name" + name);
            System.out.println("isMarked" + isMarked);
            System.out.println("type" + type);
            System.out.println("additionalInfo" + additionalInfo);
            if (type.equals("TD")) {
                arr.add(counter, new ToDo(name));
            } else if (type.equals("D")) {
                arr.add(counter, new Deadline(name, additionalInfo));
            } else if (type.equals("E")) {
                arr.add(counter, new Event(name, additionalInfo));
            }
            if (Boolean.parseBoolean(isMarked)) {
                arr.get(counter).markTask();
            }
            counter++;
        }
        return arr;
    }
}