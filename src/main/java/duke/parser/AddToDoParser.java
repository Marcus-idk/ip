package duke.parser;
public class AddToDoParser {
    private String name;
    public AddToDoParser() {
    }
    public void getData(String str) {
        if (str.trim().equals("")) throw new
        this.name = str;
    }
    public String getName() {
        return this.name;
    }
}