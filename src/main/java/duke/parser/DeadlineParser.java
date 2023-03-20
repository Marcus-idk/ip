package duke.parser;
import duke.tasks.Deadline;
import duke.tasks.Task;

import java.time.LocalDateTime;

public class DeadlineParser {
    public Task parse(String name, boolean marked, String dateData) {
        String[] dateTimeData = dateData.split(" ");
        int day = Integer.parseInt(dateTimeData[0]);
        int month = Integer.parseInt(dateTimeData[1]);
        int year = Integer.parseInt(dateTimeData[2]);
        int hours = Integer.parseInt(dateTimeData[3].substring(0, 2));
        int mins = Integer.parseInt(dateTimeData[3].substring(2));
        Deadline task = new Deadline(name, LocalDateTime.of(year, month, day, hours, mins));
        if (marked) task.markTask();
        return task;
    }
}
