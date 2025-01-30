public class Todo extends Task {
    private String type;

    public Todo(String description) {
        super(description);
        this.type = "T";
    }

    public String getDescription() {
        return description;
    }
    
    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[" + getType() + "]" + super.toString();
    }

    @Override
    public String toSave() {
        return getType() + " | " + getStatusIcon() + " | " + description;
    }
}
