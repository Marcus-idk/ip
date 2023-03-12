package duke;
import duke.commands.Command;
import duke.commands.DeleteTaskCommand;
import duke.tasks.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.mockito.Mockito;
public class DeleteTaskCommandTest {
    class TaskListStub extends TaskList {
        private ArrayList<Task> arr;
        public TaskListStub(ArrayList<Task> arr) {
            this.arr = arr;
        }
        public Task get(int index) {
            return arr.get(index);
        }
        public void remove(int index) {
            arr.remove(index);
        }
        public int size() {
            return arr.size();
        }
    }
    private UI ui;
    private Storage storage;
    @BeforeEach
    void init() {
        ui = Mockito.mock(UI.class);
        storage = Mockito.mock(Storage.class);
    }
    @Test
    public void deleteCommand_deleteOneTask_success() throws InvalidInputException, IOException {
        ArrayList<Task> arr = new ArrayList<>();
        arr.add(new Task("hi"));
        TaskListStub taskList = new TaskListStub(arr);
        Command command = new DeleteTaskCommand(1);
        command.execute(taskList, ui, storage);
        assertEquals(taskList.size(), 0);
    }
    @Test
    public void deleteCommand_deleteEmptyList_fail() {
        ArrayList<Task> arr = new ArrayList<>();
        TaskListStub taskList = new TaskListStub(arr);
        Command command = new DeleteTaskCommand(1);
        assertThrows(IndexOutOfBoundsException.class, () -> command.execute(taskList, ui, storage));
    }
    @Test
    public void deleteCommand_deleteMultipleTasks_success() throws InvalidInputException, IOException {
        ArrayList<Task> arr = new ArrayList<>();
        arr.add(new Task("1"));
        arr.add(new Task("2"));
        arr.add(new Task("3"));
        TaskListStub taskList = new TaskListStub(arr);
        Command command = new DeleteTaskCommand(1);
        command.execute(taskList, ui, storage);
        command = new DeleteTaskCommand(2);
        command.execute(taskList, ui, storage);
        assertEquals(taskList.get(0).getName(), "2");
    }
}