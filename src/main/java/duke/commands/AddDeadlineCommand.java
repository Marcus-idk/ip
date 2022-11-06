package duke.commands;
import duke.tasks.Deadline;
import duke.tasks.Task;
import java.io.IOException;
import duke.*;
public class AddDeadlineCommand extends Command {
    public AddDeadlineCommand(String commandDetails) {
        super(commandDetails);
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) throws InsufficientArgumentsException, IOException {
        addDeadline(commandDetails, arr, ui);
        storage.save(arr);
    }
    public void addDeadline(String commandDetails, TaskList arr, UI ui) {
        String[] splitBySlash = commandDetails.split("/");
        String taskName = splitBySlash[0].trim();
        String taskDate = splitBySlash[1].trim();
        Task task = new Deadline(taskName, taskDate);
        arr.add(task);
        ui.addToList(task, arr);
    }
}