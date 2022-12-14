package duke.commands;
import duke.*;
import duke.tasks.Event;
import duke.tasks.Task;

import java.io.IOException;
import java.time.LocalDateTime;

public class AddEventCommand extends Command {
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    public AddEventCommand(String name, LocalDateTime startTime, LocalDateTime endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) throws savedFileNotFoundException {
        addEvent(this.name, this.startTime, this.endTime, arr, ui);
        storage.save(arr);
    }
    public void addEvent(String name, LocalDateTime startTime, LocalDateTime endTime, TaskList arr, UI ui) {
        Task task = new Event(name, startTime, endTime);
        arr.add(task);
        ui.addToList(task, arr);
    }
}
