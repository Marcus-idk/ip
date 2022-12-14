package duke.commands;
import duke.*;
import java.io.IOException;
public class MarkTaskCommand extends Command {
    private int index;
    public MarkTaskCommand(int index) {
        this.index = index;
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) throws savedFileNotFoundException {
        markTask(index, arr, ui);
        storage.save(arr);
    }
    public static void markTask(int index, TaskList list, UI ui) {
        list.get(index - 1).markTask();
        ui.markTask(index - 1, list);
    }
}
