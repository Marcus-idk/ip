package duke;
import duke.commands.Command;
import duke.parser.Parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private TaskList arr = new TaskList();
    private String path;
    public Storage(String filePath, Parser parser, UI ui) throws IOException, InvalidInputException {
        File data = new File(filePath);
        path = filePath;
        Scanner reader = new Scanner(data);
        while (reader.hasNext()) { //TD,jump,true
            String dataString = reader.nextLine();
            String[] splitByComma = dataString.split(",");
            String type = splitByComma[0];
            String name = splitByComma[1];
            boolean isMarked = Boolean.parseBoolean(splitByComma[2]);
            String stringToBeParsed = type + " " + name;
            Command c = parser.parse(stringToBeParsed);
            c.execute(arr, ui, this);
            if (isMarked) {
                String mark = "mark " + (arr.size() - 1);
                parser.parse(mark).execute(arr, ui, this);
            }
            c.execute(arr, ui, this);
        }
    }
    public TaskList getData() {
        return this.arr;
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