package duke;

public class MarkTaskParser {
    private int index;
    public MarkTaskParser() {

    }
    public void getData(String str) {
        this.index = Integer.parseInt(str);
    }
    public int getIndex() {
        return this.index;
    }
}
