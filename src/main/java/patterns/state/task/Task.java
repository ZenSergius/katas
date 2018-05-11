package patterns.state.task;

public class Task {

    private TaskStatus taskStatus;

    public Task()
    {
        setStatus(new IdleStatus(this));
    }

    public String getStatus()
    {
        return this.taskStatus.getStatus();
    }

    public void setStatus(TaskStatus newTaskStatus)
    {
        this.taskStatus = newTaskStatus;
    }

    public void start() {
        this.taskStatus.start();
    }

    public void stop()
    {
        this.taskStatus.stop();
    }

    public void qa()
    {
        this.taskStatus.qa();
    }

    public void done()
    {
        this.taskStatus.done();
    }
}
