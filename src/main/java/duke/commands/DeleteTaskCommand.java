package duke.commands;
import duke.*;
import java.io.IOException;
public class DeleteTaskCommand extends Command {
    private int index;
    public DeleteTaskCommand(int index) {
        this.index = index;
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) throws savedFileNotFoundException {
        deleteTask(this.index, arr, ui);
        storage.save(arr);
    }
    public static void deleteTask(int index, TaskList list, UI ui) {
        list.remove(index - 1);
        ui.deleteTask(index, list);
    }
}
