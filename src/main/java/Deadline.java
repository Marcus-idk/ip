import java.time.LocalDate;
public class Deadline extends Task { //subtype of Task
    private String deadline;
    public Deadline(String name, String deadline) {
        super(name);
        this.deadline = deadline;
    }
    public String getDeadline() {
        return this.deadline;
    }
    @Override
    public String getDescription() {
        return "[D]" + super.getDescription() + " " + this.deadline;
    }
    @Override
    public String getType() {
        return "D";
    }
}