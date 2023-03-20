package duke;

import duke.commands.Command;
import duke.parser.Parser;
import duke.tasks.ToDo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class DeleteCommandIntegrationTest {
    private Storage storage;
    private TaskList list;
    private Parser parser;
    private UI ui;
    @BeforeEach
    void f() throws InvalidInputException, IOException {
        ui = new UI();
        parser = new Parser();
        storage = new Storage("C:\\Users\\Marcus\\Documents\\NUS\\CS2103\\ip\\src\\integrationTest\\java\\resources\\dataForTesting.txt", parser, ui);
        list = storage.getData();
    }
    @Test
    public void deleteCommand_deleteOneTask_success() throws InvalidInputException, IOException {
        list.add(new ToDo("jia"));
        String commandString = "delete 1";
        Command command = parser.parse(commandString);
        command.execute(list, ui, storage);
        assertEquals(list.size(), 1);

    }
}