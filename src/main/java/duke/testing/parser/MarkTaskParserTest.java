package duke.testing.parser;
import duke.parser.DeleteParser;
import duke.parser.MarkTaskParser;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class MarkTaskParserTest {
    public MarkTaskParserTest() {

    }
    @Test
    public void TestCase1() { //test normal
        String input = "delete 1";
        MarkTaskParser parser = new MarkTaskParser();
        parser.getData(input);
        assertEquals(parser.getIndex(), 1);
    }
    @Test
    public void TestCase2() { //test big values
        String input = "delete 999";
        MarkTaskParser parser = new MarkTaskParser();
        parser.getData(input);
        assertEquals(parser.getIndex(), 999);
    }
    @Test
    public void TestCase3() { //test boundary values
        String input = "delete 0";
        MarkTaskParser parser = new MarkTaskParser();
        parser.getData(input);
        assertEquals(parser.getIndex(), 0);
    }
    @Test
    public void TestCase4() { //test negative values
        String input = "delete -1";
        MarkTaskParser parser = new MarkTaskParser();
        parser.getData(input);
        assertEquals(parser.getIndex(), -1);
    }
    @Test
    public void TestCase5() { //test invalid inputs
        String input = "delete one";
        MarkTaskParser parser = new MarkTaskParser();
        parser.getData(input); //how to catch here
        assertEquals(parser.getIndex(), "");
        fail();
    }
}
