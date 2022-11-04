package duke.tasks;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task { //subtype of Task
    private LocalDateTime datetime;
    public Deadline(String name, String deadline) throws IndexOutOfBoundsException { //deadline wash /by 26 12 2022 0600
        super(name);
        String info = getAfterBy(deadline);
        LocalDateTime datetime = getSpecifics(info);
        this.datetime = datetime;
    }
    public String getAfterBy(String str) throws IndexOutOfBoundsException {
        String info = str.split(" ", 2)[1];
        return info;
    }
    public LocalDateTime getSpecifics(String str) {
        String[] split = str.split(" ");
        int day = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int year = Integer.parseInt(split[2]);
        int hour = Integer.parseInt(split[3].substring(0, 2));
        int min = Integer.parseInt(split[3].substring(2));
        System.out.println("." + year + " " + month + " " + day + " " + hour + " " + min);
        LocalDateTime data = LocalDateTime.of(year, month, day, hour, min);
        return data;
    }
    public LocalDateTime getTime() {
        return this.datetime;
    }
    @Override
    public String getDescription() {
        return "[D]" + super.getDescription() + ": by " + this.datetime;
    }
    @Override
    public String getType() {
        return "D";
    }
    @Override
    public String toString() {
        return this.getName() + ", " + this.isMarked() + ", " + this.getType() + ", " + this.datetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
}