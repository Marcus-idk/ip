package duke.commands;
import duke.*;
import duke.tasks.Event;
import duke.tasks.Task;

import java.io.IOException;
public class AddEventCommand extends Command {
    public AddEventCommand(String commandDetails) {
        super(commandDetails);
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) throws InsufficientArgumentsException, IOException {
        addEvent(commandDetails, arr, ui);
        storage.save(arr);
    }
    public void addEvent(String commandDetails, TaskList arr, UI ui) {
        String[] splitBySlash = commandDetails.split("/");
        String taskName = splitBySlash[0].trim();
        String taskDate = splitBySlash[1].trim();
        Task task = new Event(taskName, taskDate);
        arr.add(task);
        ui.addToList(task, arr);
    }
}
