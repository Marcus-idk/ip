public class toDos extends Task {
    public toDos(String name) {
        super(name);
    }
    @Override
    public String getDescription() {
        return "[T]" + super.getDescription();
    }
}
