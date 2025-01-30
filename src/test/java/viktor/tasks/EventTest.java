package viktor.tasks;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EventTest {

    @Test
    public void testEventConstructor() {
        Event event = new Event("meeting", "1/2/2025 1000", "1/2/2025 1200");
        assertNotNull(event);
    }

    @Test
    public void testGetType() {
        Event event = new Event("meeting", "1/2/2025 1000", "1/2/2025 1200");
        assertEquals("E", event.getType());
    }

    @Test
    public void testGetDescription() {
        Event event = new Event("meeting", "1/2/2025 1000", "1/2/2025 1200");
        assertEquals("meeting", event.getDescription());
    }

    @Test
    public void testMatchesDate() {
        Event event = new Event("meeting", "1/2/2025 1000", "1/2/2025 1200");
        assertTrue(event.matchesDate(LocalDate.of(2025, 2, 1)));
    }

    @Test
    public void testToString() {
        Event event = new Event("meeting", "1/2/2025 1000", "1/2/2025 1200");
        assertEquals("[E][ ] meeting (from: Feb. 1 2025, 10:00 to: Feb. 1 2025, 12:00)", event.toString());
    }

    @Test
    public void testBeDone() {
        Event event = new Event("meeting", "1/2/2025 1000", "1/2/2025 1200");
        event.beDone();
        assertEquals("[E][X] meeting (from: Feb. 1 2025, 10:00 to: Feb. 1 2025, 12:00)", event.toString());
    }

    @Test
    public void testBeUndone() {
        Event event = new Event("meeting", "1/2/2025 1000", "1/2/2025 1200");
        event.beDone();
        event.beUndone();
        assertEquals("[E][ ] meeting (from: Feb. 1 2025, 10:00 to: Feb. 1 2025, 12:00)", event.toString());
    }

    @Test
    public void testToSave() {
        Event event = new Event("meeting", "1/2/2025 1000", "1/2/2025 1200");
        assertEquals("E |   | meeting | Feb. 1 2025, 10:00 | Feb. 1 2025, 12:00", event.toSave());
    }
}
