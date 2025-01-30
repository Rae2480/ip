package viktor.tasks;

import viktor.parser.DateParser;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class Deadline extends Task {
    private String type;
    private LocalDateTime by;

    public Deadline(String description, String by) {
        super(description);
        this.type = "D";
        this.by = DateParser.parseDateTime(by);;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getType() {
        return type;
    }

    public boolean matchesDate(LocalDate targetDate) {
        return targetDate.equals(by.toLocalDate());
    }


    @Override
    public String toString() {
        return "[" + getType() + "][" + getStatusIcon() + "] " + super.toString() + " (by: " + DateParser.formatDateTime(by) + ")";
    }

    @Override
    public String toSave() {
        return getType() + " | " + getStatusIcon() + " | " + description + " | " + DateParser.formatDateTime(by);
    }
}
