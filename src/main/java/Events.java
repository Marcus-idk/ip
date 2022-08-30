public class Events extends Task {
    private String timing;
    public Events(String name, String timing) {
        super(name);
        this.timing = timing;
    }
    public String getTiming() {
        return this.timing;
    }
    @Override
    public String getDescription() {
        return "[E]" + super.getDescription() + " " + this.timing;
    }
}