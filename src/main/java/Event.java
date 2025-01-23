public class Event extends Task {
    private String type;
    private String from;
    private String to;

    public Event(String description, String from, String to) {
        super(description);
        this.type = "E";
        this.from = from;
        this.to = to;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[" + getType() + "]" + super.toString() + " (from:" + from + " to:" + to + ")";
    }
    
}
