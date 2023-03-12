package duke;
import duke.commands.AddDeadlineCommand;
import duke.commands.Command;
import duke.tasks.Deadline;
import duke.tasks.Task;
import duke.tasks.ToDo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddDeadlineCommandTest {
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
    public void addDeadlineCommand_addOneTaskSize_success() throws InvalidInputException, IOException {
        ArrayList<Task> arr = new ArrayList<>();
        TaskListStub taskList = new TaskListStub(arr);
        Command command = new AddDeadlineCommand("Dance", LocalDateTime.of(2022, 12, 4, 12, 0));
        command.execute(taskList, ui, storage);
        assertEquals(taskList.size(), 1);
    }
    @Test
    public void addDeadlineCommand_addOneTaskType_success() throws InvalidInputException, IOException {
        ArrayList<Task> arr = new ArrayList<>();
        TaskListStub taskList = new TaskListStub(arr);
        Command command = new AddDeadlineCommand("Dance", LocalDateTime.of(2022, 12, 4, 12, 0));
        command.execute(taskList, ui, storage);
        assertEquals(taskList.get(0).getType(), new Deadline("123",LocalDateTime.of(2022, 12, 4, 12, 0)).getType());
    }
    @Test
    public void addDeadlineCommand_addTwoTasksSize_success() throws InvalidInputException, IOException {
        ArrayList<Task> arr = new ArrayList<>();
        TaskListStub taskList = new TaskListStub(arr);
        Command command1 = new AddDeadlineCommand("Dance", LocalDateTime.of(2022, 12, 4, 12, 0));
        command1.execute(taskList, ui, storage); //add first task
        Command command2 = new AddDeadlineCommand("Dance", LocalDateTime.of(2020, 12, 4, 12, 0));
        command2.execute(taskList, ui, storage); //add second task
        assertEquals(taskList.size(), 2);
    }
//    @Test
//    public void addDeadlineCommand_taskDate_success() throws InvalidInputException, IOException {
//        ArrayList<Task> arr = new ArrayList<>();
//        TaskListStub taskList = new TaskListStub(arr);
//        Command command1 = new AddDeadlineCommand("jia123", LocalDateTime.of(2022, 12, 4, 12, 0));
//        command1.execute(taskList, ui, storage);
//        assertEquals(taskList.get(0).getTime(), "jia123");
//    }
}
