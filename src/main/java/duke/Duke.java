package duke;

import duke.commands.Command;
import duke.parser.Parser;

import java.io.FileNotFoundException;
import java.io.IOException;

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
            parser = new Parser();
            storage = new Storage(filePath, parser, ui);
            task = storage.getData();
            this.runProgram();
        } catch (FileNotFoundException e) {
            ui.fileNotFound();
        } catch (InsufficientArgumentsException | UnrecognizedCommandException e) {
            ui.indexOutOfBounds();
            ui.or();
            ui.unrecognizedCommand();
            ui.divider();
        } catch (IOException e) {
            ui.IOException();
            ui.divider();
        }
    }
    public void runProgram() {
        while (active) {
            try {
                String commandString = ui.readCommand();
                Command command = parser.parse(commandString);
                command.execute(task, ui, storage);
            } catch (IndexOutOfBoundsException | InsufficientArgumentsException | NumberFormatException |
                     UnrecognizedCommandException e) {
                ui.indexOutOfBounds();
                ui.or();
                ui.unrecognizedCommand();
                ui.divider();
            } catch (IOException e) {
                ui.IOException();
                ui.divider();
            }
        }
    }
}