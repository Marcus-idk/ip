public class ToDo extends Task { //subtype of Task
    public ToDo(String name) {
        super(name);
    }
    @Override
    public String getDescription() {
        return "[T]" + super.getDescription();
    }
}
