package patterns.state.task;

public abstract class TaskStatus {
    protected Task task;

    public TaskStatus(Task task)
    {
        this.task = task;
    }

    abstract public String getStatus();

    public void start() {}

    public void stop() {}

    public void qa() {}

    public void done() {}
}
