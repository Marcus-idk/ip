package duke.commands;
import duke.*;
import java.io.IOException;
public class UnMarkTaskCommand extends Command {
    public UnMarkTaskCommand(String commandDetails) {
        super(commandDetails);
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) throws IOException {
        int index = Integer.parseInt(commandDetails);
        unMarkTask(index, arr, ui);
        storage.save(arr);
    }
    public static void unMarkTask(int index, TaskList list, UI ui) {
        list.get(index - 1).unMarkTask();
        ui.unMarkTask(index - 1, list);
    }
}
