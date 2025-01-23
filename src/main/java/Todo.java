public class Todo extends Task {
    private String type;

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
        return "[" + getType() + "]" + super.toString();
    }
}
