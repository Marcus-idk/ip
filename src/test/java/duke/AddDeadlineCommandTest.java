package duke;
import duke.commands.AddDeadlineCommand;
import duke.commands.Command;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddDeadlineCommandTest {
    class TaskListStub<T extends Task> extends TaskList {
        private ArrayList<T> arr;
        public TaskListStub(ArrayList<T> arr) {
            this.arr = arr;
        }
        public T get(int index) {
            return arr.get(index);
        }
        @SuppressWarnings("unchecked")
        public void add(Task task) { arr.add((T) task); }
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
        TaskListStub<Deadline> taskList = new TaskListStub(arr);
        LocalDateTime time = LocalDateTime.of(2022, 12, 4, 12, 0);
        Command command = new AddDeadlineCommand("Dance", time);
        command.execute(taskList, ui, storage);
        assertEquals(taskList.size(), 1);
        assertEquals(taskList.get(0).getType(), new Deadline("123", time).getType());
        assertEquals(taskList.get(0).getTime(), time);
    }
    @Test
    public void addDeadlineCommand_addTwoTasksSize_success() throws InvalidInputException, IOException {
        ArrayList<Task> arr = new ArrayList<>();
        TaskListStub<Deadline> taskList = new TaskListStub(arr);
        Command command1 = new AddDeadlineCommand("Dance", LocalDateTime.of(2022, 12, 4, 12, 0));
        command1.execute(taskList, ui, storage); //add first task
        Command command2 = new AddDeadlineCommand("Dance", LocalDateTime.of(2020, 12, 4, 12, 0));
        command2.execute(taskList, ui, storage); //add second task
        assertEquals(taskList.size(), 2);
    }
}
