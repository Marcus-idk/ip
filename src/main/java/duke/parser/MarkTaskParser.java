package duke.parser;

import duke.InvalidInputException;

public class MarkTaskParser {
    private int index;
    public MarkTaskParser() {

    }
    public void getData(String str) throws InvalidInputException {
        try {
            this.index = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new InvalidInputException();
        }
    }
    public int getIndex() {
        return this.index;
    }
}
