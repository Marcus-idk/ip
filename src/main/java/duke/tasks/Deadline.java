package duke.tasks;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task { //subtype of Task
    private LocalDateTime datetime;
    public Deadline(String name, LocalDateTime deadline) throws IndexOutOfBoundsException { //deadline wash /by 26 12 2022 0600
        super(name);
        this.datetime = deadline;
    }
    public LocalDateTime getTime() {
        return this.datetime;
    }
    @Override
    public String getDescription() {
        return "[D]" + super.getDescription() + ": by " + this.datetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
    @Override
    public String getType() {
        return "D";
    }
    @Override
    public String toString() {
        return this.getName() + "," + this.isMarked() + "," + this.getType() + ",by " + this.datetime.format(DateTimeFormatter.ofPattern("dd MM yyyy HHmm"));
    }
}