package viktor.parser;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for parsing and formatting dates and times with flexible input formats.
 */
public class DateParserNew {
    private static final List<DateTimeFormatter> DATE_TIME_FORMATTERS = List.of(
        DateTimeFormatter.ofPattern("d/M/yyyy HHmm"), DateTimeFormatter.ofPattern("d/M/yyyy HH:mm"),
        DateTimeFormatter.ofPattern("d-M-yyyy HHmm"), DateTimeFormatter.ofPattern("d-M-yyyy HH:mm"),
        DateTimeFormatter.ofPattern("MMM d yyyy, HHmm"), DateTimeFormatter.ofPattern("MMM d yyyy, HH:mm"),
        DateTimeFormatter.ofPattern("d/M/yyyy hmma"), DateTimeFormatter.ofPattern("d/M/yyyy h:mma"),
        DateTimeFormatter.ofPattern("d-M-yyyy hmma"), DateTimeFormatter.ofPattern("d-M-yyyy h:mma"),
        DateTimeFormatter.ofPattern("MMM d yyyy, hmma"), DateTimeFormatter.ofPattern("MMM d yyyy, h:mma")
    );

    private static final List<DateTimeFormatter> DATE_FORMATTERS = List.of(
        DateTimeFormatter.ofPattern("d/M/yyyy"),
        DateTimeFormatter.ofPattern("d-M-yyyy"),
        DateTimeFormatter.ofPattern("MMM d yyyy")
    );

    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM d yyyy, HH:mm");
    private static final DateTimeFormatter OUTPUT_DATE_FORMATTER = DateTimeFormatter.ofPattern("MMM d yyyy");

    /**
     * Parses a date and time string into a LocalDateTime object using multiple formats,
     * including relative date expressions.
     *
     * @param dateTimeStr the date and time string to parse
     * @return the parsed LocalDateTime object
     * @throws DateTimeParseException if the date and time string cannot be parsed
     */
    public static LocalDateTime parseDateTime(String dateTimeStr) throws DateTimeParseException {
        dateTimeStr = dateTimeStr.trim().toLowerCase();

        // Check for relative dates first
        LocalDate relativeDate = parseRelativeDate(dateTimeStr);
        if (relativeDate != null) {
            return relativeDate.atStartOfDay();
        }

        // Try standard date parsing
        for (DateTimeFormatter formatter : DATE_TIME_FORMATTERS) {
            try {
                return LocalDateTime.parse(dateTimeStr, formatter);
            } catch (DateTimeParseException ignored) {
                // try next format
            }
        }

        throw new DateTimeParseException("Invalid date-time format", dateTimeStr, 0);
    }

    /**
     * Parses a date string into a LocalDate object, supporting relative dates.
     *
     * @param dateInput the date string to parse
     * @return the parsed LocalDate object
     * @throws DateTimeParseException if the date string cannot be parsed
     */
    public static LocalDate parseDateOnly(String dateInput) throws DateTimeParseException {
        dateInput = dateInput.trim().toLowerCase();

        // Check for relative dates
        LocalDate relativeDate = parseRelativeDate(dateInput);
        if (relativeDate != null) {
            return relativeDate;
        }

        // Try standard date parsing
        for (DateTimeFormatter formatter : DATE_FORMATTERS) {
            try {
                return LocalDate.parse(dateInput, formatter);
            } catch (DateTimeParseException ignored) {
                // try next format
            }
        }

        throw new DateTimeParseException("Invalid date format", dateInput, 0);
    }

    /**
     * Detects and parses relative dates like "tomorrow", "next Monday", or "in 3 days".
     *
     * @param input the relative date expression
     * @return the corresponding LocalDate, or null if input is not a relative date
     */
    private static LocalDate parseRelativeDate(String input) {
        LocalDate today = LocalDate.now();

        switch (input) {
        case "today":
            return today;
        case "tomorrow":
            return today.plusDays(1);
        case "yesterday":
            return today.minusDays(1);
        default:
            break;
        }

        // Match "in X days" format
        Pattern inDaysPattern = Pattern.compile("in (\\d+) days?");
        Matcher matcher = inDaysPattern.matcher(input);
        if (matcher.matches()) {
            int daysToAdd = Integer.parseInt(matcher.group(1));
            return today.plusDays(daysToAdd);
        }

        // Match "next Monday", "this Friday", etc.
        Pattern dayOfWeekPattern =
                Pattern.compile("(next|this) (monday|tuesday|wednesday|thursday|friday|saturday|sunday)");
        matcher = dayOfWeekPattern.matcher(input);
        if (matcher.matches()) {
            String modifier = matcher.group(1);
            DayOfWeek targetDay = DayOfWeek.valueOf(matcher.group(2).toUpperCase());

            return getNextOrThisDay(today, targetDay, modifier.equals("next"));
        }

        return null;
    }

    /**
     * Gets the date for the next or this occurrence of a given weekday.
     *
     * @param today      the current date
     * @param targetDay  the target day of the week
     * @param isNextWeek whether to get the next occurrence (instead of this week)
     * @return the LocalDate of the target day
     */
    private static LocalDate getNextOrThisDay(LocalDate today, DayOfWeek targetDay, boolean isNextWeek) {
        LocalDate result = today.with(targetDay);
        if (isNextWeek || result.isBefore(today)) {
            return result.plusWeeks(1);
        }
        return result;
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(OUTPUT_FORMATTER);
    }

    public static String formatDate(LocalDate date) {
        return date.format(OUTPUT_DATE_FORMATTER);
    }
}
