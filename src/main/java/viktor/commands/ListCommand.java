package viktor.commands;

import viktor.exceptions.ViktorException;
import viktor.tasks.TaskList;
import viktor.ui.UI;

/**
 * Command to list all task in the task list.
 */
public class ListCommand implements Commandable {
    private TaskList tasks;

    /**
     * Constructs the ListCommand with task list.
     * 
     * @param taskList The list of tasks.
     */
    public ListCommand(TaskList tasks) {
        this.tasks = tasks;
    }

    /**
     * Executes the command to list all tasks in the task list.
     * 
     * @throws ViktorException If the input is invalid or there is an error with task creation.
     */
    @Override
    public void execute() throws ViktorException {
        if (tasks.isEmpty()) {
            System.out.println("No tasks added yet!");
        } else {
            System.out.println( UI.CURLY_START + "Your tasks await you: \n");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.getTask(i));
            }
            System.out.println('\n' + "Currently, you have " + tasks.size() + " tasks in the list." + UI.CURLY_END);
        }
    }
}