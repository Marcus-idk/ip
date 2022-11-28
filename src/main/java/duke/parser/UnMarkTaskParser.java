package duke.parser;

public class UnMarkTaskParser {
    private int index;
    public UnMarkTaskParser() {

    }
    public void getData(String str) {
        this.index = Integer.parseInt(str);
    }
    public int getIndex() {
        return this.index;
    }
}
