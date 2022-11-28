package duke.tasks;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task { //subtype of Task
    private final LocalDateTime datetime;
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
        return "deadline";
    }
    @Override
    public String toString() { //D,run,true,by 20 12 2022 1800
        return this.getTime() + "," + this.getName() + "," + this.isMarked() + ",by " + this.datetime.format(DateTimeFormatter.ofPattern("dd MM yyyy HHmm"));
    }
}