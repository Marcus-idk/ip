package duke.commands;
import duke.TaskList;
import duke.UI;
import duke.Storage;
import java.io.IOException;
import duke.InsufficientArgumentsException;
public abstract class Command {
    protected String commandDetails;
    public Command(String commandDetails) {
        this.commandDetails = commandDetails;
    }
    public abstract void execute(TaskList arr, UI ui, Storage storage) throws InsufficientArgumentsException, IOException;
}