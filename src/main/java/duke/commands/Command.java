package duke.commands;
import duke.InvalidInputException;
import duke.TaskList;
import duke.UI;
import duke.Storage;

import java.io.IOException;

public abstract class Command {
    public Command() {
    }
    public abstract void execute(TaskList arr, UI ui, Storage storage) throws IOException, InvalidInputException;
}