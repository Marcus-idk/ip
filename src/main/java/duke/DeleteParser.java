package duke;
public class DeleteParser extends Parser {
    private int index;
    public DeleteParser() {

    }
    public void getData(String str) {
        this.index = Integer.parseInt(str);
    }
    public int getIndex() {
        return this.index;
    }
}