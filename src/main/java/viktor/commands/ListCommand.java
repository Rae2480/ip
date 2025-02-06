package viktor.commands;

import viktor.exceptions.ViktorException;
import viktor.tasks.TaskList;

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
    public String execute() throws ViktorException {
        if (tasks.isEmpty()) {
            return "No tasks added yet!";
        } else {
            StringBuilder response = new StringBuilder("Your tasks await you: \n");
            for (int i = 0; i < tasks.size(); i++) {
                response.append((i + 1) + ". " + tasks.getTask(i).toString() + "\n");
            }
            response.append('\n' + "Currently, you have " + tasks.size() + " tasks in the list.");
            return response.toString();
        }
    }
}
