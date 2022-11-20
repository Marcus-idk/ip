package duke;

import java.time.LocalDateTime;

public class AddDeadlineParser { //deadline wash dishes /by 2 12 2002 1200
    private String name;
    private LocalDateTime deadline;
    public AddDeadlineParser() {

    }
    public void getData(String str) {
        this.name = getNameFromData(str);
        this.deadline = getDeadlineFromData(str);
    }
    public String getNameFromData(String str) {
        String name = str.split("/by")[0].trim();
        return name;
    }
    public LocalDateTime getDeadlineFromData(String str) {
        String afterBy = str.split("/by")[1];
        String[] split = afterBy.split(" ");
        int day = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int year = Integer.parseInt(split[2]);
        int hour = Integer.parseInt(split[3].substring(0, 2));
        int min = Integer.parseInt(split[3].substring(2));
        LocalDateTime data = LocalDateTime.of(year, month, day, hour, min);
        return data;
    }
    public String getName() {
        return this.name;
    }
    public LocalDateTime getDeadline() {
        return this.deadline;
    }
}