package duke.parser;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.ToDo;

import java.time.LocalDateTime;

public class EventParser {
    public Task parse(String name, boolean marked, String startDateData, String endDateData) {
        String[] dateTimeDataStart = startDateData.split(" ");
        int day = Integer.parseInt(dateTimeDataStart[0]);
        int month = Integer.parseInt(dateTimeDataStart[1]);
        int year = Integer.parseInt(dateTimeDataStart[2]);
        int hours = Integer.parseInt(dateTimeDataStart[3].substring(0, 2));
        int mins = Integer.parseInt(dateTimeDataStart[3].substring(2));

        String[] dateTimeDataEnd = endDateData.split(" ");
        int day2 = Integer.parseInt(dateTimeDataEnd[0]);
        int month2 = Integer.parseInt(dateTimeDataEnd[1]);
        int year2 = Integer.parseInt(dateTimeDataEnd[2]);
        int hours2 = Integer.parseInt(dateTimeDataEnd[3].substring(0, 2));
        int mins2 = Integer.parseInt(dateTimeDataEnd[3].substring(2));
        Event task = new Event(name, LocalDateTime.of(year, month, day, hours, mins), LocalDateTime.of(year2, month2, day2, hours2, mins2));
        if (marked) task.markTask();
        return task;
    }
}
