package duke;
import duke.commands.AddToDoCommand;
import duke.commands.Command;
import duke.tasks.Task;
import duke.tasks.ToDo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTodoCommandTest {
    class TaskListStub extends TaskList {
        private ArrayList<Task> arr;
        public TaskListStub(ArrayList<Task> arr) {
            this.arr = arr;
        }
        public Task get(int index) {
            return arr.get(index);
        }
        public void add(Task task) { arr.add(task); }
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
    public void addTodoCommand_addOneTaskSize_success() throws InvalidInputException, IOException {
        ArrayList<Task> arr = new ArrayList<>();
        TaskListStub taskList = new TaskListStub(arr);
        Command command = new AddToDoCommand("123");
        command.execute(taskList, ui, storage);
        assertEquals(taskList.size(), 1);
    }
    @Test
    public void addTodoCommand_addOneTaskType_success() throws InvalidInputException, IOException {
        ArrayList<Task> arr = new ArrayList<>();
        TaskListStub taskList = new TaskListStub(arr);
        Command command = new AddToDoCommand("123");
        command.execute(taskList, ui, storage);
        assertEquals(taskList.get(0).getType(), new ToDo("123").getType());
    }
    @Test
    public void addTodoCommand_addTwoTasksSize_success() throws InvalidInputException, IOException {
        ArrayList<Task> arr = new ArrayList<>();
        TaskListStub taskList = new TaskListStub(arr);
        Command command1 = new AddToDoCommand("123");
        command1.execute(taskList, ui, storage); //add first task
        Command command2 = new AddToDoCommand("456");
        command2.execute(taskList, ui, storage); //add second task
        assertEquals(taskList.size(), 2);
    }
    @Test
    public void addTodoCommand_taskName_success() throws InvalidInputException, IOException {
        ArrayList<Task> arr = new ArrayList<>();
        TaskListStub taskList = new TaskListStub(arr);
        Command command1 = new AddToDoCommand("jia123");
        command1.execute(taskList, ui, storage); //add first task
        assertEquals(taskList.get(0).getName(), "jia123");
    }
}