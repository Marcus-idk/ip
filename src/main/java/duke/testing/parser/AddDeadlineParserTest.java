package duke.testing.parser;
import duke.parser.AddDeadlineParser;
import duke.parser.DeleteParser;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AddDeadlineParserTest {
    public AddDeadlineParserTest() {

    }
    @Test
    public void TestCase1() { //normal test
        String input = "deadline eat /by 4 12 2022 1200";
        AddDeadlineParser parser = new AddDeadlineParser();
        parser.getData(input);
        String name = parser.getName();
        LocalDateTime datetime = parser.getDeadline();
        String expectedName = "eat";
        LocalDateTime expectedDatetime = LocalDateTime.of(2022, 12, 4, 12, 0);
        assertEquals(name, expectedName);
        assertEquals(datetime, expectedDatetime);
    }
    @Test
    public void TestCase2() { //weirder tests
        String input = "deadline e a t buffet :) /by 4 12 2040 1930";
        AddDeadlineParser parser = new AddDeadlineParser();
        parser.getData(input);
        String name = parser.getName();
        LocalDateTime datetime = parser.getDeadline();
        String expectedName = "e a t buffet :)";
        LocalDateTime expectedDatetime = LocalDateTime.of(2040, 12, 4, 19, 30);
        assertEquals(name, expectedName);
        assertEquals(datetime, expectedDatetime);
    }
    @Test
    public void TestCase3() { //negative values, how to throw error lol
        String input = "deadline e a t buffet :) /by -4 12 2040 -1930";
        AddDeadlineParser parser = new AddDeadlineParser();
        parser.getData(input);
        String name = parser.getName();
        LocalDateTime datetime = parser.getDeadline();
        String expectedName = "e a t buffet :)";
        LocalDateTime expectedDatetime = LocalDateTime.of(2040, 12, 4, 19, 30);
        assertEquals(name, expectedName);
        assertEquals(datetime, expectedDatetime);
    }
    @Test
    public void TestCase4() { //a completely wrong input
        String input = "deadline eat /by june /by 4th dec lastyear 1930";
        AddDeadlineParser parser = new AddDeadlineParser();
        parser.getData(input);
        String name = parser.getName();
        LocalDateTime datetime = parser.getDeadline();
//        String expectedName = "e a t buffet :)";
//        LocalDateTime expectedDatetime = LocalDateTime.of(2040, 12, 4, 19, 30);
//        assertEquals(name, expectedName);
//        assertEquals(datetime, expectedDatetime);
    }
}