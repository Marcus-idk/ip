package duke.parser;
public class DeleteParser extends Parser {
    private int index;
    public DeleteParser() {

    }
    public void getData(String str) throws IndexOutOfBoundsException, NumberFormatException { //needs to be a valid string that looks like an int "32" "5"
        int index = Integer.parseInt(str);
        if (index <= 0) {
            throw new IndexOutOfBoundsException();
        } else {
            this.index = index;
        }
    }
    public int getIndex() {
        return this.index;
    }
}