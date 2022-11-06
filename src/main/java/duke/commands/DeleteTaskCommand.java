package duke.commands;
import duke.*;
import java.io.IOException;
public class DeleteTaskCommand extends Command {
    public DeleteTaskCommand(String commandDetails) {
        super(commandDetails);
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) throws IOException, InsufficientArgumentsException {
        deleteTask(commandDetails, arr, ui);
        storage.save(arr);
    }
    public static void deleteTask(String details, TaskList list, UI ui) throws InsufficientArgumentsException, NumberFormatException {
        if (details.equals("")) {
            throw new InsufficientArgumentsException();
        }
        int index = Integer.parseInt(details);
        String s = list.get(index - 1).getDescription();
        list.remove(index - 1);
        ui.deleteTask(index, list);
    }
}
