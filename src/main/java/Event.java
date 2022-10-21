import java.time.LocalDate;
public class Event extends Task {
    private String timing;
    public Event(String name, String timing) {
        super(name);
        this.timing = timing;
    }
    public String getTiming() {
        return this.timing;
    }
    @Override
    public String getDescription() {
        return "[E]" + super.getDescription() + " " + this.timing;
    }
    @Override
    public String getType() {
        return "T";
    }
}