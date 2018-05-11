package patterns.state.task;

public class IdleStatus extends TaskStatus {

    public IdleStatus(Task task)
    {
        super(task);
    }

    public String getStatus() {
        return "idle";
    }

    public void start() {
        this.task.setStatus(new InProgressStatus(this.task));
    }
}
