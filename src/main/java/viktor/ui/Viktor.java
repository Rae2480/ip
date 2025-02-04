package viktor.ui;

import java.io.IOException;
import java.util.ArrayList;

import viktor.commands.Commandable;
import viktor.exceptions.ViktorException;
import viktor.parser.Parser;
import viktor.storage.Storage;
import viktor.tasks.TaskList;
import viktor.tasks.Task;

public class Viktor {

    private UI ui;
    private TaskList taskList;
    private Parser parser;

    public Viktor() {
        ui = new UI();
        taskList = new TaskList();
        parser = new Parser();

        try {
            ArrayList<Task> loadedTasks = Storage.load(); 
            taskList.setTasks(loadedTasks);
        } catch (IOException e) {
            System.out.println("Are you ready to put science first and put yourself to the test?");
        }
    }

    public String getWelcomeMessage() {
        return ui.getWelcomeMessage();
    }

    public String getStartMessage() {
        return ui.getStartMessage();
    }

    public String getResponse(String input) {
        try {
            Commandable command = parser.parse(input, taskList, true);
            return command.execute();
        } catch (ViktorException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "Something went wrong! Very wrong! Hextech is alive!";
        }
    }
}
