package duke.testing;
import duke.*;
import duke.commands.ByeCommand;
import duke.commands.DeleteTaskCommand;
import duke.parser.DeleteParser;
import duke.parser.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeleteTaskCommandTest {
    public DeleteTaskCommandTest() {

    }
    @Mock
    UI ui;
    private class ParserStub extends Parser {

    }
    private class UIStub extends UI {
        public UIStub() {

        }
    }
    private class StorageStub extends Storage {
        public StorageStub(String filePath, ParserStub parser, UIStub ui) throws UnrecognizedCommandException, IOException {
            super(filePath, parser, ui);
        }
    }
    private DeleteTaskCommand command;
    private ParserStub parser;
    private UIStub ui;
    private StorageStub storage;
    @BeforeEach
    void toDo() {
        this.command = new DeleteTaskCommand();
        this.parser =
    }
}
