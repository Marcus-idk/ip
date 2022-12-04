package duke.testing.parser;
import duke.parser.AddToDoParser;
import duke.parser.DeleteParser;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AddToDoParserTest {
    public AddToDoParserTest() {

    }
    @Test
    public void TestCase1() { //normal test
        String input = "todo Wash Clothes";
        AddToDoParser parser = new AddToDoParser();
        parser.getData(input);
        assertEquals(parser.getName(), "Wash Clothes");
    }
    @Test
    public void TestCase2() { //weird tests
        String input = "todo todo m  o p o";
        AddToDoParser parser = new AddToDoParser();
        parser.getData(input);
        assertEquals(parser.getName(), "todo m  o p o");
    }
    @Test
    public void TestCase3() { //boundary tests, should return error
        String input = "todo ";
        AddToDoParser parser = new AddToDoParser();
        parser.getData(input);
        assertEquals(parser.getName(), "?");
    }
}
