package viktor.tasks;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;


public class TaskTest {

    // Test for markCompleted()
    @Test
    public void testMarkCompleted() {
        Task task = new Todo("Test task");
        assertFalse(task.getStatusIcon().equals("X"), "Task should initially not be completed.");
        
        task.beDone();
        assertTrue(task.getStatusIcon().equals("X"), "Task should be marked as completed.");
    }

    // Test for constructor and matchesDate() in Deadline class
    @Test
    public void testMatchesDate() {
        String deadlineDate = "2/12/2025 1200";
        Deadline deadline = new Deadline("Test task", deadlineDate);
        
        assertTrue(deadline.matchesDate(LocalDate.of(2025, 2, 2)), "Deadline should match the given date.");
        assertFalse(deadline.matchesDate(LocalDate.of(2025, 2, 3)), "Deadline should not match a different date.");
    }
}
