package viktor.tasks;

import viktor.parser.DateParser;
import java.time.LocalDateTime;
import java.time.LocalDate;

/**
 * Represents an deadline task with a description, and due time
 */
public class Deadline extends Task {
    private String type;
    private LocalDateTime by;

    /**
     * Constructs a Deadline task with a description and due date.
     * 
     * @param description The description of the task.
     * @param by The due date of the task in string format.
     */
    public Deadline(String description, String by) {
        super(description);
        this.type = "D";
        this.by = DateParser.parseDateTime(by);;
    }

    /**
     * Returns the description of the task.
     * 
     * @return The description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the type of the task.
     * 
     * @return The task type as a string.
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * Checks if the task matches the given date.
     * 
     * @param targetDate The target date to compare against.
     * @return True if the task's due date matches the target date, false otherwise.
     */
    public boolean matchesDate(LocalDate targetDate) {
        return targetDate.equals(by.toLocalDate());
    }

    /**
     * Returns a string representation of the deadline task.
     * 
     * @return The string representation of the task.
     */
    @Override
    public String toString() {
        return "[" + getType() + "][" + getStatusIcon() + "] " + super.toString() + " (by: " + DateParser.formatDateTime(by) + ")";
    }

    /**
     * Returns the string format for saving the deadline task.
     * 
     * @return The formatted string for saving the task.
     */
    @Override
    public String toSave() {
        return getType() + " | " + getStatusIcon() + " | " + description + " | " + DateParser.formatDateTime(by);
    }
}
