package duke.tasks;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDateTime dateTimeStart;
    private LocalDateTime dateTimeEnd;
    public Event(String name, String timing) throws IndexOutOfBoundsException { //event wash /at 6 12 2022 0600 - 8 12 2022 0800
        super(name);
        String info = getAfterAt(timing);
        LocalDateTime[] dateTimeStartAndEnd = getSpecifics(info);
        this.dateTimeStart = dateTimeStartAndEnd[0];
        this.dateTimeEnd = dateTimeStartAndEnd[1];
    }
    public String getAfterAt(String str) throws IndexOutOfBoundsException {
        String info = str.split(" ", 2)[1];
        return info;
    }
    public LocalDateTime[] getSpecifics(String str) {
        String[] split = str.split("-", 2);
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
    public LocalDateTime[] getTime() {
        return new LocalDateTime[] {this.dateTimeStart, this.dateTimeEnd};
    }
    @Override
    public String getDescription() {
        return "[D]" + super.getDescription() + ": from " + this.dateTimeStart.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + " till " + this.dateTimeEnd.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
    @Override
    public String getType() {
        return "T";
    }
    @Override
    public String toString() {
        return this.getName() + "," + this.isMarked() + "," + this.getType() + ",at " + this.dateTimeStart.format(DateTimeFormatter.ofPattern("dd MM yyyy HHmm")) + "," + this.dateTimeEnd.format(DateTimeFormatter.ofPattern("dd MM yyyy HHmm"));
    }
}