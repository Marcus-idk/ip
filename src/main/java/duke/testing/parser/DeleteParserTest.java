package duke.testing.parser;
import duke.parser.DeleteParser;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class DeleteParserTest {
    public DeleteParserTest() {

    }
    @Test
    public void TestCase1() { //test normal
        String input = "delete 1";
        DeleteParser parser = new DeleteParser();
        parser.getData(input);
        assertEquals(parser.getIndex(), 1);
    }
    @Test
    public void TestCase2() { //test big values
        String input = "delete 999";
        DeleteParser parser = new DeleteParser();
        parser.getData(input);
        assertEquals(parser.getIndex(), 999);
    }
    @Test
    public void TestCase3() { //test boundary values
        String input = "delete 0";
        DeleteParser parser = new DeleteParser();
        parser.getData(input);
        assertEquals(parser.getIndex(), 0);
    }
    @Test
    public void TestCase4() { //test negative values
        String input = "delete -1";
        DeleteParser parser = new DeleteParser();
        parser.getData(input);
        assertEquals(parser.getIndex(), -1);
    }
    @Test
    public void TestCase5() { //test invalid inputs
        String input = "delete one";
        DeleteParser parser = new DeleteParser();
        parser.getData(input); //how to catch here
        assertEquals(parser.getIndex(), "");
        fail();
    }
}