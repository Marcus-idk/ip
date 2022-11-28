package duke.tasks;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private final LocalDateTime dateTimeStart;
    private final LocalDateTime dateTimeEnd;
    public Event(String name, LocalDateTime startTime, LocalDateTime endTime) throws IndexOutOfBoundsException { //event wash /at 6 12 2022 0600 - 8 12 2022 0800
        super(name);
        this.dateTimeStart = startTime;
        this.dateTimeEnd = endTime;
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
    public String toString() { //
        return this.getName() + "," + this.isMarked() + "," + this.getType() + ",at " + this.dateTimeStart.format(DateTimeFormatter.ofPattern("dd MM yyyy HHmm")) + "," + this.dateTimeEnd.format(DateTimeFormatter.ofPattern("dd MM yyyy HHmm"));
    }
}