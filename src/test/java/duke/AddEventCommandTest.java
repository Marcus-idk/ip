package duke;
import duke.commands.AddEventCommand;
import duke.commands.Command;
import duke.tasks.Event;
import duke.tasks.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddEventCommandTest {
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
    public void addEventCommand_addOneTask_success() throws InvalidInputException, IOException {
        ArrayList<Task> arr = new ArrayList<>();
        TaskListStub<Event> taskList = new TaskListStub(arr);
        LocalDateTime start = LocalDateTime.of(2022, 12, 4, 12, 0);
        LocalDateTime end = LocalDateTime.of(2022, 12 ,5, 12, 0);
        Command command = new AddEventCommand("Dance", start, end);
        command.execute(taskList, ui, storage);
        assertEquals(taskList.size(), 1);
        assertEquals(taskList.get(0).getType(), new Event("123", start, end).getType());
        assertEquals(taskList.get(0).getTime()[0], start);
        assertEquals(taskList.get(0).getTime()[1], end);
    }
    @Test
    public void addEventCommand_addTwoTasksSize_success() throws InvalidInputException, IOException {
        ArrayList<Task> arr = new ArrayList<>();
        TaskListStub taskList = new TaskListStub(arr);
        LocalDateTime start = LocalDateTime.of(2022, 12, 4, 12, 0);
        LocalDateTime end = LocalDateTime.of(2022, 12 ,5, 12, 0);
        Command command1 = new AddEventCommand("Dance", start, end);
        command1.execute(taskList, ui, storage); //add first task
        Command command2 = new AddEventCommand("Dance", start, end);
        command2.execute(taskList, ui, storage); //add second task
        assertEquals(taskList.size(), 2);
    }
}
