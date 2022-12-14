package duke.parser;

import duke.InvalidInputException;

public class AddToDoParser {
    private String name;
    public AddToDoParser() {
    }
    public void getData(String str) throws InvalidInputException {
        if (str.trim().equals("")) throw new InvalidInputException();
        this.name = str;
    }
    public String getName() {
        return this.name;
    }
}