package viktor.commands;

import java.time.LocalDate;

import java.time.format.DateTimeParseException;
import viktor.exceptions.ViktorException;

import viktor.parser.DateParser;

import viktor.tasks.Deadline;
import viktor.tasks.Event;
import viktor.tasks.Task;
import viktor.tasks.TaskList;
import viktor.ui.UI;

/**
 * Command to list all tasks on a specific date.
 */
public class TimeCommand implements Commandable {
    private final TaskList tasks;
    private final String dateInput;

    /**
     * Constructs a TimeCommand with the given TaskList and date input.
     * 
     * @param tasks The TaskList to search for tasks.
     * @param dateInput The date to search for tasks on.
     */
    public TimeCommand(TaskList tasks, String dateInput) {
        this.tasks = tasks;
        this.dateInput = dateInput;
    }

    /**
     * Executes the command to list all tasks on the specified date.
     * 
     * @throws ViktorException If the input is invalid or there is an error with task creation.
     */
    @Override
    public void execute() throws ViktorException {
        LocalDate targetDate;

        try {
            targetDate = DateParser.parseDateOnly(dateInput);
        } catch (DateTimeParseException e) {
            throw new ViktorException("Invalid date format! Use 'd/M/yyyy', e.g., '12/12/2025'.");
        }

        boolean found = false;
        System.out.println( UI.CURLY_START +
                "Here are your tasks for " + DateParser.formatDate(targetDate) + ":\n");

        for (Task task : tasks.getTasks()) {
            if ((task instanceof Deadline && ((Deadline) task).matchesDate(targetDate)) ||
                (task instanceof Event && ((Event) task).matchesDate(targetDate))) {
                System.out.println(task);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Are you truly a scientist? There are no tasks for " 
                + DateParser.formatDate(targetDate) + "!" );
        }

        System.out.println(UI.CURLY_END);
    }
}
