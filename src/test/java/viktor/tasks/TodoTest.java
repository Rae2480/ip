package viktor.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class TodoTest {

    @Test
    void testTodoConstructor() {
        Todo todo = new Todo("Test task");
        assertNotNull(todo, "The Todo object should be created.");
    }

    @Test
    void testGetDescription() {
        Todo todo = new Todo("Test task");
        assertEquals("Test task", todo.getDescription(),
            "Description should match the one provided in the constructor.");
    }

    @Test
    void testGetType() {
        Todo todo = new Todo("Test task");
        assertEquals("T", todo.getType(), "The type of the Todo should be 'T'.");
    }

    @Test
    void testToString() {
        Todo todo = new Todo("Test task");
        assertEquals("[T] Test task", todo.toString(), "toString should return the correct string format.");
    }

    @Test
    void testToSaveandBeDone() {
        Todo todo = new Todo("Test task");
        assertEquals("T |   | Test task", todo.toSave(), "toSave should return the correct save format.");
    }

    @Test
    void testBeDoneandBeUndone() {
        Todo todo = new Todo("Test task");
        todo.beDone();
        todo.beUndone();
        assertEquals("T |   | Test task", todo.toSave(), "toSave should return the correct save format.");
    }

    @Test
    void testTodoStatus() {
        Todo todo = new Todo("Test task");
        assertEquals(" ", todo.getStatusIcon(), "Initially, the status icon should be a space.");
    }
}
