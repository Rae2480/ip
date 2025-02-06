package viktor.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class DeadlineTaskTest {

    @Test
    public void testDeadlineTaskConstructor() {
        DeadlineTask DeadlineTask = new DeadlineTask("return book", "1/2/2023 1800");
        assertNotNull(DeadlineTask);
    }

    @Test
    public void testGetType() {
        DeadlineTask DeadlineTask = new DeadlineTask("return book", "1/2/2023 1800");
        assertEquals("D", DeadlineTask.getType());
    }
    @Test
    public void testGetDescription() {
        DeadlineTask DeadlineTask = new DeadlineTask("return book", "1/2/2023 1800");
        assertEquals("return book", DeadlineTask.getDescription());
    }
    @Test
    public void testMatchesDate() {
        DeadlineTask DeadlineTask = new DeadlineTask("return book", "1/2/2023 1800");
        assertTrue(DeadlineTask.matchesDate(LocalDate.of(2023, 2, 1)));
    }
    @Test
    public void testToString() {
        DeadlineTask DeadlineTask = new DeadlineTask("return book", "1/2/2023 1800");
        assertEquals("[D][ ] return book (by: Feb. 1 2023, 18:00)", DeadlineTask.toString());
    }
    @Test
    public void testBeDone() {
        DeadlineTask DeadlineTask = new DeadlineTask("return book", "1/2/2023 1800");
        DeadlineTask.beDone();
        assertEquals("[D][X] return book (by: Feb. 1 2023, 18:00)", DeadlineTask.toString());
    }
    @Test
    public void testBeUndone() {
        DeadlineTask DeadlineTask = new DeadlineTask("return book", "1/2/2023 1800");
        DeadlineTask.beDone();
        DeadlineTask.beUndone();
        assertEquals("[D][ ] return book (by: Feb. 1 2023, 18:00)", DeadlineTask.toString());
    }
    @Test
    public void testToSave() {
        DeadlineTask DeadlineTask = new DeadlineTask("return book", "1/2/2023 1800");
        assertEquals("D |   | return book | Feb. 1 2023, 18:00", DeadlineTask.toSave());
    }
}
