package patterns.state.task;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {
    @Test
    public void testTask()
    {
        Task task = new Task();
        assertEquals("idle", task.getStatus());

        task.start();
        assertEquals("in progress", task.getStatus());

        task.qa();
        assertEquals("QA", task.getStatus());

        task.done();
        assertEquals("done", task.getStatus());
    }

    @Test
    public void testDoubleStatusChangeHasNoEffect()
    {
        Task task = new Task();

        task.stop();
        task.stop();
        assertEquals("idle", task.getStatus());

        task.start();
        task.start();
        assertEquals("in progress", task.getStatus());

        task.qa();
        task.qa();
        assertEquals("QA", task.getStatus());

        task.done();
        task.done();
        assertEquals("done", task.getStatus());
    }

    @Test
    public void testIdlePossibleTransitions()
    {
        Task task = new Task();
        IdleStatus idleStatus = new IdleStatus(task);

        task.start();
        assertEquals("in progress", task.getStatus());

        task.setStatus(idleStatus);
        task.qa();
        assertEquals("idle", task.getStatus());

        task.setStatus(idleStatus);
        task.done();
        assertEquals("idle", task.getStatus());
    }

    @Test
    public void testInProgressPossibleTransactions() {
        Task task = new Task();
        InProgressStatus inProgressStatus = new InProgressStatus(task);

        task.setStatus(inProgressStatus);
        task.qa();
        assertEquals("QA", task.getStatus());

        task.setStatus(inProgressStatus);
        task.done();
        assertEquals("in progress", task.getStatus());

        task.setStatus(inProgressStatus);
        task.stop();
        assertEquals("idle", task.getStatus());
    }

    @Test
    public void testQAPossibleTransactions() {
        Task task = new Task();
        QAStatus qaStatus = new QAStatus(task);

        task.setStatus(qaStatus);
        task.stop();
        assertEquals("idle", task.getStatus());

        task.setStatus(qaStatus);
        task.start();
        assertEquals("QA", task.getStatus());

        task.setStatus(qaStatus);
        task.done();
        assertEquals("done", task.getStatus());
    }

    @Test
    public void testDonePossibleTransactions() {
        Task task = new Task();
        DoneStatus doneStatus = new DoneStatus(task);

        task.setStatus(doneStatus);
        task.stop();
        assertEquals("done", task.getStatus());

        task.setStatus(doneStatus);
        task.start();
        assertEquals("done", task.getStatus());

        task.setStatus(doneStatus);
        task.qa();
        assertEquals("done", task.getStatus());
    }
}
