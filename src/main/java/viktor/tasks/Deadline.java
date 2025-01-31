package viktor.tasks;

import java.time.LocalDateTime;
import java.time.LocalDate;

import viktor.parser.DateParser;

public class Deadline extends Task {
    private final String type;
    private final LocalDateTime by;

    public Deadline(String description, String by) {
        super(description);
        this.type = "D";
        this.by = DateParser.parseDateTime(by);
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
