import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Random;

public class AddTaskCommand implements Commandable {
    private String userInput;
    private TaskList taskList; 
    private boolean testing;
    private Random random = new Random();
    String[] responses = {
        "The pursuit of knowledge is a noble endeavor. I've added",
        "Progress requires sacrifice, but it is always worth the cost for",
        "Even the greatest minds require assistance sometimes. You seek to",
        "Ah, progress—the double-edged sword of innovation, alongside:",
        "Every leap forward brings challenges, but such is the price of this great task,",
        "Interesting... I will have to do more research about this"
    };
    String testingResponse = ("Even the greatest minds require assistance sometimes. You seek to");

    public AddTaskCommand(String userInput, TaskList taskList, boolean testing) { 
        this.userInput = userInput;
        this.taskList = taskList;
        this.testing = testing;
    }

    @Override
    public void execute() throws ViktorException {
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

        case DEADLINE:
            String[] parts = taskDescription.split("/by");
            if (parts.length != 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                throw new ViktorException("When's the deadline? Please focus, when is it due!!");
            }
            try {
                Deadline deadline = new Deadline(parts[0].trim(), parts[1].trim());
                taskList.addTask(deadline); 
                output = deadline.getDescription();
            } catch (DateTimeParseException e) {
                throw new ViktorException("I cannot understand that date format! Use 'd/M/yyyy h:mm a', e.g., '2/12/2025 1830'.");
            }
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
            try {
                Event event = new Event(eventParts[0].trim(), timeParts[0].trim(), timeParts[1].trim());
                taskList.addTask(event); 
                output = event.getDescription();
            } catch (DateTimeParseException e) {
                throw new ViktorException("I cannot understand that date format! Use 'd/M/yyyy h:mm a', e.g., '2/12/2019 6:00 PM'.");
            }
            break;

        default:
            throw new ViktorException("Unknown command type.");
        }

        if (testing) {
            System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" +
                    testingResponse + " " + output + 
                    "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n");
        } else {
            String response = responses[random.nextInt(responses.length)];
            System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" +
                    response + " " + output + "." + 
                    "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n");
        }

        try {
            Storage.save(taskList); 
        } catch (IOException e) {
            System.out.println("An error occurred while saving tasks: " + e.getMessage());
        }
    }
}
