package duke.testing.parser;
import duke.InvalidInputException;
import duke.parser.AddEventParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class AddEventParserTest {
    public AddEventParserTest() {

    }
    private AddEventParser parser;
    @BeforeEach
    void setUp() {
        parser = new AddEventParser();
    }
    @Test
    public void getData_normal_writtenCorrectly() throws InvalidInputException { //normal test
        String input = "eat /at 4 12 2022 1200 - 5 12 2022 1200";
        parser.getData(input);
        String expectedName = "eat";
        LocalDateTime expectedStartTime = LocalDateTime.of(2022, 12, 4, 12, 0);
        LocalDateTime expectedEndTime = LocalDateTime.of(2022, 12, 5, 12, 0);
        assertEquals(parser.getName(), expectedName);
        assertEquals(parser.getStartTime(), expectedStartTime);
        assertEquals(parser.getEndTime(), expectedEndTime);
    }
    @Test
    public void getData_weird_writtenCorrectly() throws InvalidInputException { //weirder tests
        String input = "drin kk 123 bottl : 1 3 /at 4 12 2022 1200 - 5 12 2025 1200";
        parser.getData(input);
        String expectedName = "drin kk 123 bottl : 1 3";
        LocalDateTime expectedStartTime = LocalDateTime.of(2022, 12, 4, 12, 0);
        LocalDateTime expectedEndTime = LocalDateTime.of(2025, 12, 5, 12, 0);
        assertEquals(parser.getName(), expectedName);
        assertEquals(parser.getStartTime(), expectedStartTime);
        assertEquals(parser.getEndTime(), expectedEndTime);
    }
    @Test
    public void getData_inversedTime_UnrecognizedCommandException() { //inversed time
        String input = "eat /at 5 12 2025 1200 - 4 12 2022 1200";
        assertThrows(InvalidInputException.class, () -> parser.getData(input));
    }
}