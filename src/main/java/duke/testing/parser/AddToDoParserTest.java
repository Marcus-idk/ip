package duke.testing.parser;
import duke.parser.AddToDoParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AddToDoParserTest {
    public AddToDoParserTest() {

    }
    private AddToDoParser parser;
    @BeforeEach
    void setUp() {
        parser = new AddToDoParser();
    }
    @Test
    public void TestCase1() { //normal test
        String input = "Wash Clothes";
        parser.getData(input);
        assertEquals(parser.getName(), "Wash Clothes");
    }
    @Test
    public void TestCase2() { //weird tests, but should still work
        String input = "todo m  o p o";
        parser.getData(input);
        assertEquals(parser.getName(), "todo m  o p o");
    }
    @Test
    public void TestCase3() { //boundary tests, should return error
        String input = " ";
        parser.getData(input);
//        assertThrows()
//        assertEquals(parser.getName(), "?");
    }
}
