package duke.commands;
import duke.*;
import java.io.IOException;
public class UnMarkTaskCommand extends Command {
    private int index;
    public UnMarkTaskCommand(int index) {
        this.index = index;
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) throws savedFileNotFoundException {
        unMarkTask(index, arr, ui);
        storage.save(arr);
    }
    public static void unMarkTask(int index, TaskList list, UI ui) {
        list.get(index - 1).unMarkTask();
        ui.unMarkTask(index - 1, list);
    }
}
