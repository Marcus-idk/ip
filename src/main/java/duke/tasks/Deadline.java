package duke.tasks;

import java.time.LocalDateTime;
public class Deadline extends Task { //subtype of Task
    private String time;
    public Deadline(String name, String deadline) throws IndexOutOfBoundsException { //deadline wash /by june
        super(name);
        this.time = getAfterBy(deadline);
    }
    public String getAfterBy(String str) throws IndexOutOfBoundsException {
        String info = str.split(" ", 2)[1];
        return info;
    }
    @Override
    public String getTime() {
        return this.time;
    }
    @Override
    public String getDescription() {
        return "[D]" + super.getDescription() + ": by " + this.time;
    }
    @Override
    public String getType() {
        return "D";
    }
}