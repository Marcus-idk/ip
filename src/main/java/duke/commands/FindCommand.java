package duke.commands;
import duke.*;
public class FindCommand extends Command {
    public FindCommand(String commandDetails) {
        super(commandDetails);
    }
    @Override
    public void execute(TaskList arr, UI ui, Storage storage) throws InsufficientArgumentsException {
        find(arr, commandDetails, ui);
    }
    public static void find(TaskList arr, String str, UI ui) throws InsufficientArgumentsException {
        if (str.equals("")) throw new InsufficientArgumentsException();
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
