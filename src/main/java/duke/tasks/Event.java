package duke.tasks;
import java.time.LocalDate;
import java.time.LocalTime;
public class Event extends Task {
    private String time;
    public Event(String name, String timing) throws IndexOutOfBoundsException {
        super(name);
        this.time = getAfterAt(timing);
    }
    public String getAfterAt(String str) throws IndexOutOfBoundsException {
        String info = str.split(" ", 2)[1];
        return info;
    }
    @Override
    public String getTime() {
        return this.time;
    }
    @Override
    public String getDescription() {
        return "[D]" + super.getDescription() + ": at " + this.time;
    }
    @Override
    public String getType() {
        return "T";
    }
}