//package duke.testing;
//import duke.*;
//import duke.commands.ByeCommand;
//import duke.parser.DeleteParser;
//import duke.parser.Parser;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//
//import static org.junit.Assert.fail;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//public class ByeCommandTest {
//    public ByeCommandTest() {
//
//    }
//    private ByeCommand command;
//    @BeforeEach
//    void setUp() { command = new ByeCommand(); }
//    private class UIStub extends UI {
//
//    }
//    private class StorageStub extends Storage {
//        public StorageStub(String filePath, Parser parser, UI ui) throws IOException, UnrecognizedCommandException, InsufficientArgumentsException {
//            super(filePath, parser, ui);
//        }
//    }
//    private class TaskListStub extends TaskList {
//
//    }
//    private class ParserStub extends Parser {
//        public
//    }
//    @Test public void execute_normal_writtenCorrectly() throws IOException, UnrecognizedCommandException, InsufficientArgumentsException {
//        command.execute(new TaskListStub(), new UIStub(), new StorageStub("hi", ));
//    }
//}