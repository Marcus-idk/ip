import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.ToDo;
import duke.tasks.Task;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> arr;
    public TaskList(ArrayList<Task> data) {
        arr = new ArrayList<>(data);
    }
    public int size() {
        return this.arr.size();
    }

    public Task get(int i) {
        return this.arr.get(i);
    }

    public void add(Task task) {
        this.arr.add(task);
    }

    public void remove(int i) {
        this.arr.remove(i);
    }
}