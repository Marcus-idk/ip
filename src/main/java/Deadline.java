import java.time.LocalDate;
public class Deadline extends Task { //subtype of Task
    private String preposition;
    private LocalDate deadline;
    public Deadline(String name, String deadline) {
        super(name);
        String[] splitBySlash = deadline.split(" ", 2);
        String preposition = splitBySlash[0];
        String desc = splitBySlash[1];
        LocalDate d = LocalDate.parse(desc);
        this.deadline = d;
        this.preposition = preposition;
    }
    public LocalDate getDeadline() {
        return this.deadline;
    }
    @Override
    public String getDescription() {
        return "[D]" + super.getDescription() + " " + preposition + ": " + this.deadline;
    }
    @Override
    public String getType() {
        return "D";
    }
}