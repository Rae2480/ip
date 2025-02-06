package viktor.ui;

/**
 * This class represents the user interface for Viktor.
 */
public class UI {
    /**
     * Returns the welcome message.
     *
     * @return the welcome message string
     */
    public String getWelcomeMessage() {
        return "Hello! I'm Viktor!\n" + "What can I do for you today?\n";
    }
    public String getStartMessage() {
        return "Here are some of my advanced capabilities:\n\n"
                + "Adding Tasks:\n"
                + "  ✦ `add todo buy groceries`\n"
                + "  ✦ `add deadline return book /by 2/12/2025 1800`\n"
                + "  ✦ `add event meeting /at 2/12/2025 1800`\n\n"
                + "Deleting a Task:\n"
                + "  ✦ `delete 2`\n\n"
                + "Marking Tasks as Done:\n"
                + "  ✦ `mark 3`\n\n"
                + "Viewing Tasks:\n"
                + "  ➤ `list` - Show all tasks in your list\n"
                + "Finding Tasks:\n"
                + "  ✦ `find book`\n\n"
                + "Viewing Tasks by Date:\n"
                + "  ✦ `time 2/12/2025`\n\n"
                + "Exiting the Program:\n"
                + "  ✦ `bye`\n\n"
                + "What can I do for you today?\n";
    }
}
