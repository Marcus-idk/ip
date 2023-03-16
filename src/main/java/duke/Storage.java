package duke;
import duke.commands.Command;
import duke.parser.Parser;
import duke.tasks.Deadline;
import duke.tasks.Event;
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
            String[] splitByComma = dataString.split(",");
            String type = splitByComma[0];
            String name = splitByComma[1];
            boolean marked = Boolean.parseBoolean(splitByComma[2]);
            if (type.equals("todo")) {
                ToDo task = new ToDo(name);
                if (marked) task.markTask();
                list.add(task);
            } else if (type.equals("deadline")) {
                String[] dateTimeData = splitByComma[3].split(" ");
                int day = Integer.parseInt(dateTimeData[0]);
                int month = Integer.parseInt(dateTimeData[1]);
                int year = Integer.parseInt(dateTimeData[2]);
                int hours = Integer.parseInt(dateTimeData[3].substring(0, 2));
                int mins = Integer.parseInt(dateTimeData[3].substring(2));
                Deadline task = new Deadline(name, LocalDateTime.of(year, month, day, hours, mins));
                if (marked) task.markTask();
                list.add(task);
            } else {
                String[] dateTimeDataStart = splitByComma[3].split(" ");
                int day = Integer.parseInt(dateTimeDataStart[0]);
                int month = Integer.parseInt(dateTimeDataStart[1]);
                int year = Integer.parseInt(dateTimeDataStart[2]);
                int hours = Integer.parseInt(dateTimeDataStart[3].substring(0, 2));
                int mins = Integer.parseInt(dateTimeDataStart[3].substring(2));

                String[] dateTimeDataEnd = splitByComma[4].split(" ");
                int day2 = Integer.parseInt(dateTimeDataEnd[0]);
                int month2 = Integer.parseInt(dateTimeDataEnd[1]);
                int year2 = Integer.parseInt(dateTimeDataEnd[2]);
                int hours2 = Integer.parseInt(dateTimeDataEnd[3].substring(0, 2));
                int mins2 = Integer.parseInt(dateTimeDataEnd[3].substring(2));
                Event task = new Event(name, LocalDateTime.of(year, month, day, hours, mins), LocalDateTime.of(year2, month2, day2, hours2, mins2));
                if (marked) task.markTask();
                list.add(task);
            }
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