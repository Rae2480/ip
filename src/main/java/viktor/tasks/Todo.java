package viktor.tasks;
public class Todo extends Task {
    private final String type;

    public Todo(String description) {
        super(description);
        this.type = "T";
    }
    
    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[" + getType() + "] " + super.toString();
    }

    @Override
    public String toSave() {
        return getType() + " | " + getStatusIcon() + " | " + description;
    }
}
