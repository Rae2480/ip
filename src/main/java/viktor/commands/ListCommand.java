package viktor.commands;

import viktor.exceptions.ViktorException;
import viktor.tasks.TaskList;


public class ListCommand implements Commandable {
    private TaskList tasks;

    public ListCommand(TaskList tasks) {
        this.tasks = tasks;
    }

    @Override
    public void execute() throws ViktorException {
        if (tasks.isEmpty()) {
            System.out.println("No tasks added yet!");
        } else {
            System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" 
                + "Your tasks await you: \n");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.getTask(i));
            }
            System.out.println('\n' + "Currently, you have " + tasks.size() 
                    + " tasks in the list." 
                    + "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n");
        }
    }
}