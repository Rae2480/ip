import java.time.LocalDate;
import java.time.LocalDateTime;

public class Event extends Task {
    private String type;
    private LocalDateTime from;
    private LocalDateTime to;

    public Event(String description, String from, String to) {
        super(description);
        this.type = "E";
        this.from = DateParser.parseDateTime(from);;
        this.to = DateParser.parseDateTime(to);;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getType() {
        return type;
    }

    public boolean matchesDate(LocalDate targetTime) {
        LocalDate targetDate = targetTime;
        return !targetDate.isBefore(from.toLocalDate()) && !targetDate.isAfter(to.toLocalDate());
}

    @Override
    public String toString() {
        return "[" + getType() + "]" + super.toString() + " (from: " + DateParser.formatDateTime(from) + " to: " + DateParser.formatDateTime(to) + ")";
    }

    @Override
    public String toSave() {
        return getType() + " | " + getStatusIcon() + " | " + description + " | " + DateParser.formatDateTime(from) + " | " + DateParser.formatDateTime(to);
    }
    
}
