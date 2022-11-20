package duke;
public class AddToDoParser {
    private String name;
    public AddToDoParser() {
    }
    public void getData(String str) {
        this.name = str;
    }
    public String getName() {
        return this.name;
    }
}