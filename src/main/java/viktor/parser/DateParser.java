package viktor.parser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Utility class for parsing and formatting dates and times.
 */
public class DateParser {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM d yyyy, HH:mm");
    private static final DateTimeFormatter INPUT_DATE_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy");
    private static final DateTimeFormatter OUTPUT_DATE_FORMATTER = DateTimeFormatter.ofPattern("MMM d yyyy");
    private static final DateTimeFormatter ALTERNATIVE_FORMATTER = DateTimeFormatter.ofPattern("MMM d yyyy, HH:mm");

    /**
     * Parses a date and time string into a LocalDateTime object.
     *
     * @param dateTimeStr the date and time string to parse
     * @return the parsed LocalDateTime object
     * @throws DateTimeParseException if the date and time string cannot be parsed
     */
    public static LocalDateTime parseDateTime(String dateTimeStr) throws DateTimeParseException {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, INPUT_FORMATTER);
            assert dateTime != null : "DateTime is null for parseDateTime";
            return dateTime;
        } catch (DateTimeParseException e) {
            return LocalDateTime.parse(dateTimeStr, ALTERNATIVE_FORMATTER);
        }
    }


    /**
     * Formats a LocalDateTime object into a string with the format MMM d yyyy, HH:mm.
     *
     * @param dateTime the LocalDateTime object to format
     * @return the formatted string
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        assert dateTime != null : "DateTime is null for formatDateTime";
        return dateTime.format(OUTPUT_FORMATTER);
    }

    /**
     * Parses a date string into a LocalDate object.
     *
     * @param dateInput the date string to parse
     * @return the parsed LocalDate object
     * @throws DateTimeParseException if the date string cannot be parsed
     */
    public static LocalDate parseDateOnly(String dateInput) throws DateTimeParseException {
        LocalDate date = LocalDate.parse(dateInput, INPUT_DATE_FORMATTER);
        assert date != null : "Date is null for parseDateOnly";
        return date;
    }

    /**
     * Formats a LocalDate object into a string with the format MMM d yyyy.
     *
     * @param date the LocalDate object to format
     * @return the formatted string
     */
    public static String formatDate(LocalDate date) {
        return date.format(OUTPUT_DATE_FORMATTER);
    }
}
