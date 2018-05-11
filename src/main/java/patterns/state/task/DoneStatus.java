package patterns.state.task;

public class DoneStatus extends TaskStatus {
    public DoneStatus(Task task) {
        super(task);
    }

    public String getStatus() {
        return "done";
    }
}
