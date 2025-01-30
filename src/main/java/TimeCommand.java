import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TimeCommand implements Commandable {
    private TaskList tasks;
    private String dateInput;

    public TimeCommand(TaskList tasks, String dateInput) {
        this.tasks = tasks;
        this.dateInput = dateInput;
    }

    @Override
    public void execute() throws ViktorException {
        LocalDate targetDate;

        try {
            targetDate = DateParser.parseDateOnly(dateInput);
        } catch (DateTimeParseException e) {
            throw new ViktorException("Invalid date format! Use 'd/M/yyyy', e.g., '12/12/2025'.");
        }

        boolean found = false;
        System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" +
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

        System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n");
    }
}
