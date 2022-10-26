import java.time.LocalDate;
import java.time.LocalTime;
public class Event extends Task {
    private String time;

    public Event(String name, String timing) {
        super(name);
        this.time = timing;
    }
    @Override
    public String getTime() {
        return this.time;
    }
    @Override
    public String getDescription() {
        return "[D]" + super.getDescription() + ": " + this.time;
    }
    @Override
    public String getType() {
        return "T";
    }
}