package duke.parser;

import duke.UnrecognizedCommandException;

public class AddToDoParser {
    private String name;
    public AddToDoParser() {
    }
    public void getData(String str) throws UnrecognizedCommandException {
        if (str.trim().equals("")) throw new UnrecognizedCommandException();
        this.name = str;
    }
    public String getName() {
        return this.name;
    }
}