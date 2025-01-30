import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateParser {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM d yyyy, HH:mm");
    private static final DateTimeFormatter INPUT_DATE_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy");
    private static final DateTimeFormatter OUTPUT_DATE_FORMATTER = DateTimeFormatter.ofPattern("MMM d yyyy");
    private static final DateTimeFormatter ALTERNATIVE_FORMATTER = DateTimeFormatter.ofPattern("MMM d yyyy, HH:mm");



    public static LocalDateTime parseDateTime(String dateTimeStr) throws DateTimeParseException {
        try {
            return LocalDateTime.parse(dateTimeStr, INPUT_FORMATTER);
        } catch (DateTimeParseException e) {
            return LocalDateTime.parse(dateTimeStr, ALTERNATIVE_FORMATTER);
        }
    }
    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(OUTPUT_FORMATTER);
    }

    public static LocalDate parseDateOnly(String dateInput) throws DateTimeParseException {
        return LocalDate.parse(dateInput, INPUT_DATE_FORMATTER);
    }

    public static String formatDate(LocalDate date) {
        return date.format(OUTPUT_DATE_FORMATTER);
    }
}

