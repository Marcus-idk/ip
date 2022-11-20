package duke.commands;
import duke.*;
public class ShowListCommand extends Command {
    public ShowListCommand() {
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) {
        ui.showList(arr);
    }
}
