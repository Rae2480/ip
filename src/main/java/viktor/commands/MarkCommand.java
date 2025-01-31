package viktor.commands;

import java.io.IOException;
import viktor.exceptions.ViktorException;

import viktor.storage.Storage;

import viktor.tasks.TaskList;
import viktor.ui.UI;

public class MarkCommand implements Commandable {
    private int taskNumber;
    private TaskList tasks;

    public MarkCommand(int taskNumber, TaskList tasks) {
        this.taskNumber = taskNumber;
        this.tasks = tasks;
    }

    @Override
    public void execute() throws ViktorException {
        if (taskNumber >= tasks.size()) {
            throw new ViktorException("You're asking for the impossible! That task doesn't exist.");
        }
        tasks.getTask(taskNumber).beDone();
        System.out.println(UI.CURLY_START + "You've just finished " + tasks.getTask(taskNumber).getDescription()
                            + "! True progress is still far away but a bit less further now!" + UI.CURLY_END);
        try {
            Storage.save(tasks);
        } catch (IOException e) {
            System.out.println("Ah something must've gone awry: " + e.getMessage() 
                    + " Well, mistakes are but a part of progress.");
        }
    }
}

