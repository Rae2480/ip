package viktor.commands;

import java.io.IOException;
import java.util.Random;

import viktor.exceptions.ViktorException;
import viktor.storage.Storage;
import viktor.tasks.DeadlineTask;
import viktor.tasks.Event;
import viktor.tasks.TaskList;
import viktor.tasks.TaskType;
import viktor.tasks.Todo;

/**
 * Command to add a task to the task list based on user input.
 */
public class AddTaskCommand implements Commandable {
    private static final String[] responses = {
        "The pursuit of knowledge is a noble endeavor. I've added",
        "Progress requires sacrifice, but it is always worth the cost for",
        "Even the greatest minds require assistance sometimes. You seek to",
        "Ah, progress—the double-edged sword of innovation, alongside:",
        "Every leap forward brings challenges, but such is the price of this great task,",
        "Interesting... I will have to do more research about this"
    };
    private String userInput;
    private TaskList taskList;
    private boolean isBeingTested;
    private final Random random = new Random();
    private String testingResponse = ("Even the greatest minds require assistance sometimes. You seek to");

    /**
     * Constructs the AddTaskCommand with user input, task list, and testing mode.
     *
     * @param userInput The user's command input.
     * @param taskList The list of tasks.
     * @param testing Whether the command is in testing mode.
     */
    public AddTaskCommand(String userInput, TaskList taskList, boolean isBeingTested) {
        this.userInput = userInput;
        this.taskList = taskList;
        this.isBeingTested = isBeingTested;
    }

    /**
     * Executes the command to add a task to the task list based on user input.
     * Creates a Todo, DeadlineTask, or Event task and adds it to the task list, depending on user input.
     * Prints a randomised response to the user, echoing the task description.
     * During testing, responses are fixed.
     * Saves saves the task list after the task is added.
     * @throws ViktorException If the input is invalid or there is an error with task creation.
     */
    @Override
    public String execute() throws ViktorException {
        String[] words = userInput.split(" ");
        TaskType taskType = TaskType.valueOf(words[0].toUpperCase());

        if (words.length < 2) {
            throw new ViktorException("There's something you're not telling me!");
        }

        String taskDescription = userInput.substring(words[0].length()).trim();
        String output = "";

        switch (taskType) {
        case TODO:
            Todo todo = new Todo(taskDescription);
            taskList.addTask(todo);
            output = todo.getDescription();
            break;

        case DeadlineTask:
            String[] parts = taskDescription.split("/by");
            if (parts.length != 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                throw new ViktorException("When's the DeadlineTask? Please focus, when is it due!!");
            }
            DeadlineTask deadlineTask = new DeadlineTask(parts[0].trim(), parts[1].trim());
            taskList.addTask(deadlineTask);
            output = deadlineTask.getDescription();
            break;

        case EVENT:
            String[] eventParts = taskDescription.split("/from", 2);
            if (eventParts.length < 2) {
                throw new ViktorException("Invalid event! You have to give me some details.");
            }
            String[] timeParts = eventParts[1].split("/to", 2);
            if (timeParts.length < 2) {
                throw new ViktorException("Invalid event input! Please provide both start and end times.");
            }
            Event event = new Event(eventParts[0].trim(), timeParts[0].trim(), timeParts[1].trim());
            taskList.addTask(event);
            output = event.getDescription();
            break;

        default:
            throw new ViktorException("Unknown command type.");
        }

        String response = isBeingTested ? testingResponse : responses[random.nextInt(responses.length)];
        try {
            Storage.save(taskList);
        } catch (IOException e) {
            return "An error occurred while saving tasks: " + e.getMessage();
        }

        return response + " " + output + ".";
    }

}
