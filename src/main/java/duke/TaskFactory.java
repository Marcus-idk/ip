package duke;
import duke.parser.DeadlineParser;
import duke.parser.EventParser;
import duke.parser.ToDoParser;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.ToDo;

import java.time.LocalDateTime;

public class TaskFactory {
    public Task parseTask(String content) {
        String[] splitByComma = content.split(",");
        String type = splitByComma[0];
        String name = splitByComma[1];
        boolean marked = Boolean.parseBoolean(splitByComma[2]);
        if (type.equals("todo")) {
            ToDoParser parser = new ToDoParser();
            return parser.parse(name, marked);
        } else if (type.equals("deadline")) {
            DeadlineParser parser = new DeadlineParser();
            return parser.parse(name, marked, splitByComma[3]);
        } else {
            EventParser parser = new EventParser();
            return parser.parse(name, marked, splitByComma[3], splitByComma[4]);
        }
    }
}
