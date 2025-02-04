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
    public String execute() throws ViktorException {
        boolean found = false;
        StringBuilder response = new StringBuilder( "Here are your tasks matching \"" + nameInput + "\":\n");

        for (Task task : tasks.getTasks()) {
            if (task.getDescription().contains(nameInput)) {
                response.append(task).append("\n");
                found = true;
            }
        }

        if (!found) {
            response.append("Vast emptiness is all there is. \"").append(nameInput)
                    .append("\"? I haven't heard of that in a long, long time. ")
                    .append("There are no tasks matching \"").append(nameInput).append("\"!");
        }

        response.append("\n");
        return response.toString();
    }
}
