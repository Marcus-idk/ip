package duke.testing.parser;
import duke.parser.AddEventParser;
import duke.parser.DeleteParser;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AddEventParserTest {
    public AddEventParserTest() {

    }
    @Test
    public void TestCase1() { //normal test
        String input = "eat /at 4 12 2022 1200 - 5 12 2022 1200";
        AddEventParser parser = new AddEventParser();
        parser.getData(input);
        String name = parser.getName();
        LocalDateTime startTime = parser.getStartTime();
        LocalDateTime endTime = parser.getEndTime();
        String expectedName = "eat";
        LocalDateTime expectedStartTime = LocalDateTime.of(2022, 12, 4, 12, 0);
        LocalDateTime expectedEndTime = LocalDateTime.of(2022, 12, 5, 12, 0);
        assertEquals(name, expectedName);
        assertEquals(startTime, expectedStartTime);
        assertEquals(endTime, expectedEndTime);
    }
    @Test
    public void TestCase2() { //weirder tests
        String input = "drin kk 123 bottl : 1 3 /at 4 12 2022 1200 - 5 12 2025 1200";
        AddEventParser parser = new AddEventParser();
        parser.getData(input);
        String name = parser.getName();
        LocalDateTime startTime = parser.getStartTime();
        LocalDateTime endTime = parser.getEndTime();
        String expectedName = "drin kk 123 bottl : 1 3";
        LocalDateTime expectedStartTime = LocalDateTime.of(2022, 12, 4, 12, 0);
        LocalDateTime expectedEndTime = LocalDateTime.of(2025, 12, 5, 12, 0);
        assertEquals(name, expectedName);
        assertEquals(startTime, expectedStartTime);
        assertEquals(endTime, expectedEndTime);
    }
    @Test
    public void TestCase3() { //inversed time
        String input = "eat /at 5 12 2022 1200 - 4 12 2025 1200";
        AddEventParser parser = new AddEventParser();
        parser.getData(input);
        String name = parser.getName();
        LocalDateTime startTime = parser.getStartTime();
        LocalDateTime endTime = parser.getEndTime();
        String expectedName = "eat";
        LocalDateTime expectedStartTime = LocalDateTime.of(2022, 12, 5, 12, 0);
        LocalDateTime expectedEndTime = LocalDateTime.of(2025, 12, 4, 12, 0);
        assertEquals(name, expectedName);
        assertEquals(startTime, expectedStartTime);
        assertEquals(endTime, expectedEndTime);
    }
    @Test
    public void TestCase4() { //double "at"s, throw error
        String input = "at /at /at 5 12 2022 1200 - 4 12 2025 1200";
        AddEventParser parser = new AddEventParser();
        parser.getData(input);
        String name = parser.getName();
        LocalDateTime startTime = parser.getStartTime();
        LocalDateTime endTime = parser.getEndTime();
        String expectedName = "eat";
        LocalDateTime expectedStartTime = LocalDateTime.of(2022, 12, 5, 12, 0);
        LocalDateTime expectedEndTime = LocalDateTime.of(2025, 12, 4, 12, 0);
        assertEquals(name, expectedName);
        assertEquals(startTime, expectedStartTime);
        assertEquals(endTime, expectedEndTime);
    }
}