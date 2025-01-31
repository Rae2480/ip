package viktor.commands;

import viktor.exceptions.ViktorException;
import viktor.tasks.Task;
import viktor.tasks.TaskList;
import viktor.ui.UI;


public class FindCommand implements Commandable {
    private TaskList tasks;
    private String nameInput;

    public FindCommand(TaskList tasks, String nameInput) {
        this.tasks = tasks;
        this.nameInput = nameInput;
    }

    @Override
    public void execute() throws ViktorException {

        boolean found = false;
        System.out.println( UI.CURLY_START + "Here are your tasks matching " + nameInput + ":\n");

        for (Task task : tasks.getTasks()) {
            if ((task.getDescription().contains(nameInput))) {
                System.out.println(task);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Vast emptiness is all there is" + nameInput 
                + "? I haven't heard of that in a long, long time. There are no tasks matching " + nameInput + "!" );
        }

        System.out.println(UI.CURLY_END);
    }
}
