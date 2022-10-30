import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private ArrayList<Task> taskArr;
    private String path;
    public Storage(String filePath) throws FileNotFoundException {
        ArrayList<Task> arr = new ArrayList<>();
        File data = new File(filePath);
        path = filePath;
        Scanner reader = new Scanner(data);
        int counter = 0;
        while (reader.hasNextLine()) {
            String dataString = reader.nextLine();
            String[] split = dataString.split(",");
            String name = split[1];
            String isMarked = split[2];
            String type = split[3];
            String additionalInfo = "";
            if (split.length > 4) additionalInfo = split[4];
            System.out.println("name" + name);
            System.out.println("isMarked" + isMarked);
            System.out.println("type" + type);
            System.out.println("additionalInfo" + additionalInfo);
            if (type.equals("TD")) {
                arr.add(counter, new ToDo(name));
            } else if (type.equals("D")) {
                arr.add(counter, new Deadline(name, additionalInfo));
            } else if (type.equals("E")) {
                arr.add(counter, new Event(name, additionalInfo));
            }
            if (Boolean.parseBoolean(isMarked)) {
                arr.get(counter).markTask();
            }
            counter++;
        }
        this.taskArr = arr;
    }
    public ArrayList<Task> getData() {
        return this.taskArr;
    }
    public void save(ArrayList<Task> arr) throws IOException { //index, name, marked, type of task
        FileWriter myWriter = new FileWriter(path);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getType().equals("D") || arr.get(i).getType().equals("E")) {
                myWriter.write((i + 1) + "," + arr.get(i).getName() + "," + arr.get(i).isMarked() + "," + arr.get(i).getType() + "," + arr.get(i).getTime());
            } else {
                myWriter.write((i + 1) + "," + arr.get(i).getName() + "," + arr.get(i).isMarked() + "," + arr.get(i).getType() + "\n");
            }
        }
        myWriter.close();
    }
}
