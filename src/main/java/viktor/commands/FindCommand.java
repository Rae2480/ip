package viktor.commands;

import viktor.exceptions.ViktorException;
import viktor.tasks.Task;
import viktor.tasks.TaskList;


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
        System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" +
                "Here are your tasks matching " + nameInput + ":\n");

        for (Task task : tasks.getTasks()) {
            if ((task.getDescription().contains(nameInput))) {
                System.out.println(task);
                found = true;
            }
        }

        if (!found) {
            System.out.println( nameInput + "? I haven't heard of that in a long, long time. There are no tasks matching " 
                 + nameInput + "!" );
        }

        System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n");
    }
}
