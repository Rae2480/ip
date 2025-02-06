package viktor.parser;

import viktor.commands.AddTaskCommand;
import viktor.commands.ByeCommand;
import viktor.commands.Commandable;
import viktor.commands.DeleteTaskCommand;
import viktor.commands.FindCommand;
import viktor.commands.ListCommand;
import viktor.commands.MarkCommand;
import viktor.commands.TimeCommand;
import viktor.commands.UnmarkCommand;
import viktor.exceptions.ViktorException;
import viktor.tasks.TaskList;



/**
 * The Parser class is responsible for interpreting user input and returning the appropriate command.
 */
public class Parser {

    /**
     * Parses the user input and returns the appropriate command.
     *
     * @param userInput The input string from the user.
     * @param tasks The list of tasks.
     * @param isBeingTested A flag indicating if the application is being tested.
     * @return The command corresponding to the user input.
     * @throws ViktorException If the user input is invalid.
     */
    public Commandable parse(String userInput, TaskList tasks, boolean isBeingTested) throws ViktorException {
        String[] words = userInput.split(" ", 2);
        String commandWord = words[0];

        switch (commandWord.toUpperCase()) {
        case "ADD":
            if (words.length < 2) {
                throw new ViktorException("Add? Add what?");
            }
            return new AddTaskCommand(words[1], tasks, isBeingTested);

        case "DELETE":
            if (words.length < 2) {
                throw new ViktorException("You don't even know what you want me to delete?");
            }
            try {
                int taskNumber = Integer.parseInt(words[1]);
                return new DeleteTaskCommand(taskNumber - 1, tasks);
            } catch (NumberFormatException e) {
                throw new ViktorException("Invalid task number for deletion.");
            }

        case "MARK":
            if (words.length < 2) {
                throw new ViktorException("One does not simply mark a task without specifying which one.");
            }
            try {
                int taskNumber = Integer.parseInt(words[1]);
                return new MarkCommand(taskNumber - 1, tasks);
            } catch (NumberFormatException e) {
                throw new ViktorException("Invalid task number to mark.");
            }

        case "UNMARK":
            if (words.length < 2) {
                throw new ViktorException("You've got to be clearer what you want me to unmark.");
            }
            try {
                int taskNumber = Integer.parseInt(words[1]);
                return new UnmarkCommand(taskNumber - 1, tasks);
            } catch (NumberFormatException e) {
                throw new ViktorException("Invalid task number to unmark.");
            }

        case "LIST":
            return new ListCommand(tasks);

        case "FIND":
            if (words.length < 2) {
                throw new ViktorException("Find what?");
            }
            return new FindCommand(tasks, words[1]);

        case "BYE":
            return new ByeCommand();

        case "TIME":
            if (words.length < 2) {
                throw new ViktorException("Please specify a date for the search.");
            }
            return new TimeCommand(tasks, words[1]);

        default:
            throw new ViktorException("Unknown command: " + commandWord);
        }
    }
}
