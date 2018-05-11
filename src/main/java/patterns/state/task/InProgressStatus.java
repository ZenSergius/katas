package patterns.state.task;

public class InProgressStatus extends TaskStatus {
    public InProgressStatus(Task task) {
        super(task);
    }

    public String getStatus() {
        return "in progress";
    }

    public void stop() {
        this.task.setStatus(new IdleStatus(this.task));
    }

    public void qa()
    {
        this.task.setStatus(new QAStatus(this.task));
    }
}
