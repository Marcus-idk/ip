package duke;
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
            ToDo task = new ToDo(name);
            if (marked) task.markTask();
            return task;
        } else if (type.equals("deadline")) {
            String[] dateTimeData = splitByComma[3].split(" ");
            int day = Integer.parseInt(dateTimeData[0]);
            int month = Integer.parseInt(dateTimeData[1]);
            int year = Integer.parseInt(dateTimeData[2]);
            int hours = Integer.parseInt(dateTimeData[3].substring(0, 2));
            int mins = Integer.parseInt(dateTimeData[3].substring(2));
            Deadline task = new Deadline(name, LocalDateTime.of(year, month, day, hours, mins));
            if (marked) task.markTask();
            return task;
        } else {
            String[] dateTimeDataStart = splitByComma[3].split(" ");
            int day = Integer.parseInt(dateTimeDataStart[0]);
            int month = Integer.parseInt(dateTimeDataStart[1]);
            int year = Integer.parseInt(dateTimeDataStart[2]);
            int hours = Integer.parseInt(dateTimeDataStart[3].substring(0, 2));
            int mins = Integer.parseInt(dateTimeDataStart[3].substring(2));

            String[] dateTimeDataEnd = splitByComma[4].split(" ");
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
}
