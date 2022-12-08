package duke.commands;
import duke.tasks.Deadline;
import duke.tasks.Task;
import java.io.IOException;
import java.time.LocalDateTime;

import duke.*;
public class AddDeadlineCommand extends Command {
    private String name;
    private LocalDateTime deadline;
    public AddDeadlineCommand(String name, LocalDateTime deadline) {
        this.name = name;
        this.deadline = deadline;
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) throws IOException {
        addDeadline(name, deadline, arr, ui);
        storage.save(arr);
    }
    public void addDeadline(String name, LocalDateTime deadline, TaskList arr, UI ui) {
        Task task = new Deadline(name, deadline);
        arr.add(task);
        ui.addToList(task, arr);
    }
}