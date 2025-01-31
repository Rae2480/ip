package viktor.tasks;
import java.time.LocalDate;
import java.time.LocalDateTime;
import viktor.parser.DateParser;

/**
 * Represents an event task with a description, start time, and end time.
 */
public class Event extends Task {
    private String type;
    private LocalDateTime from;
    private LocalDateTime to;

    /**
     * Constructs a Event task with a description, start and end date.
     * 
     * @param description The description of the task.
     * @param from The start date of the task in string format.
     * @param to The end date of the task in string format.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.type = "E";
        this.from = DateParser.parseDateTime(from);;
        this.to = DateParser.parseDateTime(to);;
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
     * Checks if the task's time range includes the given date.
     * 
     * @param targetDate The target date to compare against.
     * @return True if the target date is within the event's time range, false otherwise.
     */
    public boolean matchesDate(LocalDate targetTime) {
        LocalDate targetDate = targetTime;
        return !targetDate.isBefore(from.toLocalDate()) && !targetDate.isAfter(to.toLocalDate());
    }

    /**
     * Returns a string representation of the event task.
     * 
     * @return The string representation of the task.
     */
    @Override
    public String toString() {
        return "[" + getType() + "][" + getStatusIcon()+ "] " + super.toString() + " (from: " + DateParser.formatDateTime(from) + " to: " + DateParser.formatDateTime(to) + ")";
    }

    /**
     * Returns the string format for saving the event task.
     * 
     * @return The formatted string for saving the task.
     */
    @Override
    public String toSave() {
        return getType() + " | " + getStatusIcon() + " | " + description + " | " + DateParser.formatDateTime(from) + " | " + DateParser.formatDateTime(to);
    }
    
}
