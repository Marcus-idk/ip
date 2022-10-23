import java.time.LocalDate;
public class Event extends Task {
    private String preposition;
    private LocalDate date;
    private String time;
    public Event(String name, String timing) {
        super(name);
        String[] splitBySlash = timing.split(" ", 3);
        String preposition = splitBySlash[0];
        String desc = splitBySlash[1];
        String time = splitBySlash[2];
        LocalDate d = LocalDate.parse(desc);
        this.date = d;
        this.time = time;
        this.preposition = preposition;
    }
    public LocalDate getTiming() {
        return this.date;
    }
    @Override
    public String getDescription() {
        return "[E]" + super.getDescription() + " " + preposition + ": " + this.date + " " + time;
    }
    @Override
    public String getType() {
        return "T";
    }
}