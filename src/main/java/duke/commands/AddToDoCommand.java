package duke.commands;
import duke.*;
import duke.tasks.Task;
import duke.tasks.ToDo;
import java.io.IOException;

public class AddToDoCommand extends Command {
    private String name;
    public AddToDoCommand(String name) {
        this.name = name;
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) throws IOException {
        addToDo(this.name, arr, ui);
        storage.save(arr);
    }
    public void addToDo(String name, TaskList arr, UI ui) {
        Task task = new ToDo(name);
        arr.add(task);
        ui.addToList(task, arr);
    }
}