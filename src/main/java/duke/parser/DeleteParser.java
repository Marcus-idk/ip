package duke.parser;

import duke.InvalidInputException;

public class DeleteParser extends Parser {
    private int index;
    public DeleteParser() {

    }
    public void getData(String str) throws IndexOutOfBoundsException, InvalidInputException { //needs to be a valid string that looks like an int "32" "5"
        try {
            int index = Integer.parseInt(str);
            if (index <= 0) {
                throw new IndexOutOfBoundsException();
            } else {
                this.index = index;
            }
        } catch (NumberFormatException e) {
            throw new InvalidInputException();
        }
    }
    public int getIndex() {
        return this.index;
    }
}