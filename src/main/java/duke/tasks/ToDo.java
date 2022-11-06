package duke.tasks;

public class ToDo extends Task { //subtype of Task
    public ToDo(String name) {
        super(name);
    }
    @Override
    public String getDescription() {
        return "[T]" + super.getDescription();
    }
    @Override
    public String getType() { return "TD"; }
    @Override
    public String toString() {
        return this.getName() + "," + this.isMarked() + "," + this.getType();
    }
}

