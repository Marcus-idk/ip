package duke.commands;
import duke.*;
public class FindCommand extends Command {
    private String findString;
    public FindCommand() {
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) throws InvalidInputException {
        find(arr, this.findString, ui);
    }
    public static void find(TaskList arr, String str, UI ui) throws InvalidInputException {
        if (str == null || str.equals("")) throw new InvalidInputException();
        int counter = 1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getName().contains(str)) {
                ui.printCustomList(counter, i, arr);
                counter++;
            }
        }
        if (counter == 1) { ui.cannotFind(); ui.divider(); }
    }
}
