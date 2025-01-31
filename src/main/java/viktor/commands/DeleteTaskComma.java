package viktor.commands;

import java.io.IOException;
import viktor.exceptions.ViktorException;

import viktor.storage.Storage;

import viktor.tasks.TaskList;

/**
 * Command to delete a task from the task list.
 */
public class DeleteTaskComma implements Commandable {
    private int taskNumber;
    private TaskList tasks;

    /**
     * Constructs a DeleteTaskComma command with the specified task number and task list.
     * 
     * @param taskNumber The index of the task to be deleted.
     * @param tasks The list of tasks from which the task will be removed.
     */
    public DeleteTaskComma(int taskNumber, TaskList tasks) {
        this.taskNumber = taskNumber;
        this.tasks = tasks;
    }

    /**
     * Executes the command to delete a task from the task list.
     * 
     * @throws ViktorException If the input is invalid or there is an error with task creation.
     */
    @Override
    public void execute() throws ViktorException {
        if (taskNumber >= tasks.size()) {
            throw new ViktorException("You're asking for the impossible! That task doesn't exist.");
        }
        System.out.println("\nI guess "+ tasks.getTask(taskNumber).getDescription() + " is no longer your concern.\n");
        tasks.removeTask(taskNumber);
        System.out.println('\n' + "Now you have " + tasks.size() + " remaining tasks.\n");

        try {
                Storage.save(tasks);
        } catch (IOException e) {
            System.out.println("Ah something must've gone awry: " + e.getMessage() 
                    + " Well, mistakes are but a part of progress.");
        }
    }
}