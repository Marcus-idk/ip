package duke.commands;
import duke.*;
import java.io.IOException;
public class MarkTaskCommand extends Command {
    public MarkTaskCommand(String commandDetails) {
        super(commandDetails);
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) throws IOException {
        int index = Integer.parseInt(commandDetails);
        markTask(index, arr, ui);
        storage.save(arr);
    }
    public static void markTask(int index, TaskList list, UI ui) {
        list.get(index - 1).markTask();
        ui.markTask(index - 1, list);
    }
}
