package duke.parser;

import java.time.LocalDateTime;

public class AddEventParser { //event wash /at 6 12 2022 0600 - 8 12 2022 0800
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    public AddEventParser() {

    }
    public void getData(String str) {
        this.name = getNameFromData(str);
        LocalDateTime[] eventTimes = getStartAndEndTime(str);
        this.startTime = eventTimes[0];
        this.endTime = eventTimes[1];
    }
    public String getNameFromData(String str) {
        String name = str.split("/at")[0].trim();
        return name;
    }
    public LocalDateTime[] getStartAndEndTime(String str) {
        String afterAt = str.split("/at", 2)[1];
        String[] split = afterAt.split("-", 2);
        String[] start = split[0].trim().split(" ");
        String[] end = split[1].trim().split(" ");
        int dayS = Integer.parseInt(start[0]);
        int monthS = Integer.parseInt(start[1]);
        int yearS = Integer.parseInt(start[2]);
        int hourS = Integer.parseInt(start[3].substring(0, 2));
        int minS = Integer.parseInt(start[3].substring(2));
        int dayE = Integer.parseInt(end[0]);
        int monthE = Integer.parseInt(end[1]);
        int yearE = Integer.parseInt(end[2]);
        int hourE = Integer.parseInt(end[3].substring(0, 2));
        int minE = Integer.parseInt(end[3].substring(2));
        return new LocalDateTime[] { LocalDateTime.of(yearS, monthS, dayS, hourS, minS), LocalDateTime.of(yearE, monthE, dayE, hourE, minE) };
    }
    public String getName() {
        return this.name;
    }
    public LocalDateTime getStartTime() { return this.startTime; }
    public LocalDateTime getEndTime() { return this.endTime; }
}