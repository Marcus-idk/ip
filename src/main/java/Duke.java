import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.ToDo;
import duke.tasks.Task;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke { //the duke class that runs the textbot program
    private Storage storage;
    private TaskList task;
    private UI ui;
    private Parser parser;
    private boolean active = true;
    public Duke(String filePath) {
        try {
            ui = new UI();
            ui.greetUser();
            storage = new Storage(filePath);
            task = new TaskList(storage.getData());
            parser = new Parser();
            this.runProgram();
        } catch (FileNotFoundException e) {
            ui.fileNotFound();
        }
    }
    public void runProgram() {
        while (active) {
            try {
                String commandString = ui.readCommand();
                Command command = parser.parse(commandString);
                command.execute(task, ui, storage);
            } catch (IndexOutOfBoundsException | InsufficientArgumentsException | NumberFormatException | UnrecognizedCommandException e) {
                ui.indexOutOfBounds();
                System.out.print("/");
                ui.unrecognizedCommand();
            } catch (IOException e) {
                ui.IOException();
            }
        }
    }
}