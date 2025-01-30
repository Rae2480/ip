package viktor.tasks;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeadlineTest {

    @Test
    public void testDeadlineConstructor() {
        Deadline deadline = new Deadline("return book", "1/2/2023 1800");
        assertNotNull(deadline);
    }

    @Test
    public void testGetType() {
        Deadline deadline = new Deadline("return book", "1/2/2023 1800");
        assertEquals("D", deadline.getType());
    }
    @Test
    public void testGetDescription() {
        Deadline deadline = new Deadline("return book", "1/2/2023 1800");
        assertEquals("return book", deadline.getDescription());
    }
    @Test
    public void testMatchesDate() {
        Deadline deadline = new Deadline("return book", "1/2/2023 1800");
        assertTrue(deadline.matchesDate(LocalDate.of(2023, 2, 1)));
    }
    @Test
    public void testToString() {
        Deadline deadline = new Deadline("return book", "1/2/2023 1800");
        assertEquals("[D][ ] return book (by: Feb. 1 2023, 18:00)", deadline.toString());
    }
    @Test
    public void testBeDone() {
        Deadline deadline = new Deadline("return book", "1/2/2023 1800");
        deadline.beDone();
        assertEquals("[D][X] return book (by: Feb. 1 2023, 18:00)", deadline.toString());
    }
    @Test
    public void testBeUndone() {
        Deadline deadline = new Deadline("return book", "1/2/2023 1800");
        deadline.beDone();
        deadline.beUndone();
        assertEquals("[D][ ] return book (by: Feb. 1 2023, 18:00)", deadline.toString());
    }
    @Test
    public void testToSave() {
        Deadline deadline = new Deadline("return book", "1/2/2023 1800");
        assertEquals("D |   | return book | Feb. 1 2023, 18:00", deadline.toSave());
    }
}
