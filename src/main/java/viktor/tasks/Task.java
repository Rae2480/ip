package viktor.tasks;
public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void beDone() {
        this.isDone = true;
    }

    public void beUndone() {
        this.isDone = false;
    }

    public abstract String getType();

    public  String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    @Override
    public String toString() {
        return description;
    }

    public abstract String toSave();
}