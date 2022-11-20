package duke.commands;
import duke.*;
public class DoNothingCommand extends Command {
    public DoNothingCommand() {
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) {
        ui.doNothing();
    }
}