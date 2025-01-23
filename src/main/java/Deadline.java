public class Deadline extends Task {
    private String type;
    private String by;

    public Deadline(String description, String by) {
        super(description);
        this.type = "D";
        this.by = by;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[" + getType() + "]" + super.toString() + " (by:" + by + ")";
    }
}
