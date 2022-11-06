package duke.commands;
import duke.*;
public class ByeCommand extends Command {
    public ByeCommand(String commandDetails) {
        super(commandDetails);
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) {
        ui.byeUser();
        System.exit(1);
        return;
    }
}
