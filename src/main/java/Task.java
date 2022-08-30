public class Task {
    private final String name;
    private boolean marked;
    public Task(String name) {
        this.name = name;
        this.marked = false;
    }
    public void markTask() {
        this.marked = true;
    }
    public void unMarkTask() {
        this.marked = false;
    }
    public boolean isMarked() {
        return this.marked;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        if (marked) {
            return "[X] " + this.name;
        } else {
            return "[ ] " + this.name;
        }
    }
}