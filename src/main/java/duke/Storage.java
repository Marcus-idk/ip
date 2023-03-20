package duke;
import duke.commands.Command;
import duke.parser.Parser;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.ToDo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Storage {
    private TaskList list = new TaskList();
    private String path;
    public Storage(String filePath, Parser parser, UI ui) throws IOException, InvalidInputException {
        File data = new File(filePath);
        path = filePath;
        Scanner reader = new Scanner(data);
        while (reader.hasNext()) { //TD,jump,true
            String dataString = reader.nextLine();
            Task task = new TaskFactory().parseTask(dataString);
            list.add(task);
        }
    }
    public TaskList getData() {
        return this.list;
    }
    public void save(TaskList arr) throws savedFileNotFoundException {
        try {
            FileWriter myWriter = new FileWriter(this.path);
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getType().equals("D")) {
                    myWriter.write(arr.get(i).toString() + "\n");
                } else if (arr.get(i).getType().equals("E")) {
                    myWriter.write(arr.get(i).toString() + "\n");
                } else {
                    myWriter.write(arr.get(i).toString() + "\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            throw new savedFileNotFoundException();
        }
    }
}