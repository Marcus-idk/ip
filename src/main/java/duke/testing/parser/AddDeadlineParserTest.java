package duke.testing.parser;
import duke.InvalidInputException;
import duke.parser.AddDeadlineParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class AddDeadlineParserTest {
    public AddDeadlineParserTest() {

    }
    private AddDeadlineParser parser;
    @BeforeEach
    void setUp() {
        parser = new AddDeadlineParser();
    }
    @Test
    public void getData_normal_writtenCorrectly() throws InvalidInputException { //normal test
        String input = "eat /by 4 12 2022 1200";
        parser.getData(input);
        String expectedName = "eat";
        LocalDateTime expectedDatetime = LocalDateTime.of(2022, 12, 4, 12, 0);
        assertEquals(parser.getName(), expectedName);
        assertEquals(parser.getDeadline(), expectedDatetime);
    }
    @Test
    public void getData_weird_writtenCorrectly() throws InvalidInputException { //weirder tests
        String input = "e a t buffet :) /by 4 12 2040 1930";
        parser.getData(input);
        String expectedName = "e a t buffet :)";
        LocalDateTime expectedDatetime = LocalDateTime.of(2040, 12, 4, 19, 30);
        assertEquals(parser.getName(), expectedName);
        assertEquals(parser.getDeadline(), expectedDatetime);
    }
    @Test
    public void getData_negativeValues_UnrecognizedCommandException() { //negative values
        String input = "e a t buffet :) /by -4 12 2040 -1930";
        assertThrows(InvalidInputException.class, () -> parser.getData(input));
    }
    @Test
    public void getData_completelyWrong_UnrecognizedCommandException() { //a completely wrong input
        String input = "eat /by june /by 4th dec lastyear 1930";
        assertThrows(InvalidInputException.class, () -> parser.getData(input));
    }
}