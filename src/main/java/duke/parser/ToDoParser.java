package duke.parser;
import duke.tasks.Task;
import duke.tasks.ToDo;

public class ToDoParser {
    public Task parse(String name, boolean marked) {
        ToDo task = new ToDo(name);
        if (marked) task.markTask();
        return task;
    }
}
