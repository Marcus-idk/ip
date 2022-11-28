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
    public String getType() { return "todo"; }
    @Override
    public String toString() { //TD,jump,true
        return this.getType() + "," + this.getName() + "," + this.isMarked();
    }
}

