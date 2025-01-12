package parser;
import duke.InvalidInputException;
import duke.parser.DeleteParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeleteParserTest {
    public DeleteParserTest() {

    }
    private DeleteParser parser;
    @BeforeEach
    void setUp() {
        parser = new DeleteParser();
    }
    @Test
    public void getData_normal_writtenCorrectly() throws InvalidInputException { //test normal
        String input = "1";
        parser.getData(input);
        assertEquals(parser.getIndex(), 1);
    }
    @Test
    public void getData_bigValue_writtenCorrectly() throws InvalidInputException { //test big values
        String input = "999";
        parser.getData(input);
        assertEquals(parser.getIndex(), 999);
    }
    @Test
    public void getData_0OrLess_IndexOutOfBoundsException() { //test boundary values
        String[] inputs = { "0", "-1", "-999"};
        for (String input: inputs) {
            assertThrows(IndexOutOfBoundsException.class, () -> {
                parser.getData(input);
            });
        }
    }
    @Test
    public void getData_invalidInteger_InvalidInputException() { //test invalid inputs
        String input = "one";
        assertThrows(InvalidInputException.class, () -> {
            parser.getData(input);
        });
    }
}