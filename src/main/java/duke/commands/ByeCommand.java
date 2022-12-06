package duke.commands;
import duke.*;
public class ByeCommand extends Command {
    public ByeCommand() {
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) {
        ui.byeUser();
        System.exit(1);
        return;
    }
}