package duke.testing.parser;
import duke.InvalidInputException;
import duke.parser.AddToDoParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddToDoParserTest {
    public AddToDoParserTest() {

    }
    private AddToDoParser parser;
    @BeforeEach
    void setUp() {
        parser = new AddToDoParser();
    }
    @Test
    public void getData_normal_writtenCorrectly() throws InvalidInputException { //normal test
        String input = "Wash Clothes";
        parser.getData(input);
        assertEquals(parser.getName(), "Wash Clothes");
    }
    @Test
    public void getData_weird_writtenCorrectly() throws InvalidInputException { //weird tests, but should still work
        String input = "todo m  o p o";
        parser.getData(input);
        assertEquals(parser.getName(), "todo m  o p o");
    }
    @Test
    public void getData_emptyString_UnrecognizedCommandException() { //boundary tests, should return error
        String input = " ";
        assertThrows(InvalidInputException.class, () -> parser.getData(input));
    }
}
