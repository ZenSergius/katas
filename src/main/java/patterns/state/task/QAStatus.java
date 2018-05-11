package patterns.state.task;

public class QAStatus extends TaskStatus {
    public QAStatus(Task task) {
        super(task);
    }

    public String getStatus() {
        return "QA";
    }

    public void done() {
        this.task.setStatus(new DoneStatus(this.task));
    }

    public void stop() {
        this.task.setStatus(new IdleStatus(this.task));
    }
}
