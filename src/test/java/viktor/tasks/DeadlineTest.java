package viktor.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class DeadlineTest {

    @Test
    public void testDeadlineConstructor() {
        DeadlineTask Deadline = new DeadlineTask("return book", "1/2/2023 1800");
        assertNotNull(Deadline);
    }

    @Test
    public void testGetType() {
        DeadlineTask Deadline = new DeadlineTask("return book", "1/2/2023 1800");
        assertEquals("D", Deadline.getType());
    }
    @Test
    public void testGetDescription() {
        DeadlineTask Deadline = new DeadlineTask("return book", "1/2/2023 1800");
        assertEquals("return book", Deadline.getDescription());
    }
    @Test
    public void testMatchesDate() {
        DeadlineTask Deadline = new DeadlineTask("return book", "1/2/2023 1800");
        assertTrue(Deadline.matchesDate(LocalDate.of(2023, 2, 1)));
    }
    @Test
    public void testToString() {
        DeadlineTask Deadline = new DeadlineTask("return book", "1/2/2023 1800");
        assertEquals("[D][ ] return book (by: Feb. 1 2023, 18:00)", Deadline.toString());
    }
    @Test
    public void testBeDone() {
        DeadlineTask Deadline = new DeadlineTask("return book", "1/2/2023 1800");
        Deadline.beDone();
        assertEquals("[D][X] return book (by: Feb. 1 2023, 18:00)", Deadline.toString());
    }
    @Test
    public void testBeUndone() {
        DeadlineTask Deadline = new DeadlineTask("return book", "1/2/2023 1800");
        Deadline.beDone();
        Deadline.beUndone();
        assertEquals("[D][ ] return book (by: Feb. 1 2023, 18:00)", Deadline.toString());
    }
    @Test
    public void testToSave() {
        DeadlineTask Deadline = new DeadlineTask("return book", "1/2/2023 1800");
        assertEquals("D |   | return book | Feb. 1 2023, 18:00", Deadline.toSave());
    }
}
