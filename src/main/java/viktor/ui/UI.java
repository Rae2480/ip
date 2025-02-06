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
        return "Hello! I'm Viktor!\nWhat can I do for you today?\n";
    }
    public String getStartMessage() {
        return "Here are some of my advanced capabilities: \n\n"
                        + "ADD <task type> <description> - add task to your list\n"
                        + "    e.g. add todo buy groceries" + "\n"
                        + "    e.g. add DeadlineTask return book /by 2/12/2025 1800"
                        + "\n" + "    e.g. add event meeting /at 2/12/2025 1800" + "\n\n"
                        + "DELETE <task number> - remove a task from your list\n"
                        + "    e.g., delete 2" + "\n\n"
                        + "MARK <task number> - mark a task as done.\n"
                        + "    e.g., mark 3" + "\n\n"
                        + "LIST - list all tasks in your list\n"
                        + "    e.g., list" + "\n\n"
                        + "FIND <keyword> - find tasks with the keyword\n"
                        + "    e.g., find book" + "\n\n"
                        + "TIME <date> - list all tasks on a specific date\n"
                        + "    e.g., time 2/12/2025" + "\n\n"
                        + "BYE - exit the program\n"
                        + "    e.g., bye" + "\n\n"
                        + "\n\n"
                        + "What can I do for you today?\n";
    }
}
