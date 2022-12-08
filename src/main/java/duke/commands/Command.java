package duke.commands;
import duke.TaskList;
import duke.UI;
import duke.Storage;
import duke.UnrecognizedCommandException;

import java.io.IOException;

public abstract class Command {
    public Command() {
    }
    public abstract void execute(TaskList arr, UI ui, Storage storage) throws IOException, UnrecognizedCommandException;
}