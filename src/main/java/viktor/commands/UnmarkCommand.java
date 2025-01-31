package viktor.commands;

import java.io.IOException;
import viktor.exceptions.ViktorException;

import viktor.storage.Storage;

import viktor.tasks.TaskList;


public class UnmarkCommand implements Commandable {
    private int taskNumber;
    private TaskList tasks;

    public UnmarkCommand(int taskNumber, TaskList tasks) {
        this.taskNumber = taskNumber;
        this.tasks = tasks;
    }

    @Override
    public void execute() throws ViktorException {
        if (taskNumber >= tasks.size()) {
            throw new ViktorException("You're asking for the impossible! That task doesn't exist.");
        }
        tasks.getTask(taskNumber).beUndone();
        System.out.println("\n Oh you've yet to finish " + tasks.getTask(taskNumber).getDescription() 
                + "? Don't forget: progress waits for no man\n");
        try {
            Storage.save(tasks);
        } catch (IOException e) {
            System.out.println("Ah something must've gone awry: " + e.getMessage() 
                    + " Well, mistakes are but a part of progress.");
        }
    }
}