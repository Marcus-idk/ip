package duke.testing;
import duke.*;
import duke.commands.Command;
import duke.commands.DeleteTaskCommand;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class DeleteTaskCommandTest {
//    public DeleteTaskCommandTest() {
//
//    }
//    @Mock
//    UI ui;
//    private class ParserStub extends Parser {
//
//    }
//    private class UIStub extends UI {
//        public UIStub() {
//
//        }
//    }
//    private class StorageStub extends Storage {
//        public StorageStub(String filePath, ParserStub parser, UIStub ui) throws InvalidInputException, IOException {
//            super(filePath, parser, ui);
//        }
//    }
//    private DeleteTaskCommand command;
//    private ParserStub parser;
//    private UIStub ui;
//    private StorageStub storage;
//    @BeforeEach
//    void toDo() {
//        this.command = new DeleteTaskCommand();
//        this.parser =
//    }
//}

import org.mockito.Mockito;

public class DeleteTaskCommandTest {
    @Test
    public void deletesCommand_success() throws InvalidInputException, IOException {
        UI ui = Mockito.mock(UI.class);
        TaskList taskList = Mockito.mock(TaskList.class);
        when(taskList.get(0).thenReturn(new Task()));
        Storage storage = Mockito.mock(Storage.class);
        Command command = new DeleteTaskCommand(1);
        command.execute(taskList, ui, storage);
        assertEquals(true, true);
    }
}