public class toDos extends Task {
    public toDos(String name) {
        super(name);
    }
    @Override
    public String getDescription() {
        if (super.isMarked()) {
            return "[T] [X] " + super.getName();
        } else {
            return "[T] [ ] " + super.getName();
        }
    }
}
