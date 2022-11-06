package duke.commands;
import duke.*;
import duke.tasks.Task;
import duke.tasks.ToDo;
import java.io.IOException;

public class AddToDoCommand extends Command {
    public AddToDoCommand(String commandDetails) {
        super(commandDetails);
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) throws InsufficientArgumentsException, IOException {
        addToDo(commandDetails, arr, ui);
        storage.save(arr);
    }
    public void addToDo(String commandDetails, TaskList arr, UI ui) {
        Task task = new ToDo(commandDetails);
        arr.add(task);
        ui.addToList(task, arr);
    }
}