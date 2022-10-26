import java.time.LocalDateTime;
public class Deadline extends Task { //subtype of Task
    private String time;
    public Deadline(String name, String deadline) {
        super(name);
        this.time = deadline;
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
        return "D";
    }
}