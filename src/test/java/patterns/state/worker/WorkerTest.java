package patterns.state.worker;

import org.junit.Test;
import patterns.state.worker.states.EatingState;

import static org.junit.Assert.assertEquals;

public class WorkerTest {
    @Test
    public void testWorkerStatsGetters() {
        Worker worker = new Worker();

        assertEquals(100, worker.getEnergy());
        assertEquals(100, worker.getFatigue());
        assertEquals(100, worker.getHungry());
    }

    @Test
    public void testWorkerConstructor() {
        Worker worker = new Worker(30, 20, 10);

        assertEquals(30, worker.getEnergy());
        assertEquals(20, worker.getFatigue());
        assertEquals(10, worker.getHungry());
    }

    @Test
    public void testBoundaries0() {
        Worker workerMinValue = new Worker(0, 0, 0);
        assertEquals(0, workerMinValue.getEnergy());
        assertEquals(0, workerMinValue.getFatigue());
        assertEquals(0, workerMinValue.getHungry());

        Worker workerMaxValue = new Worker(100, 100, 100);
        assertEquals(100, workerMaxValue.getEnergy());
        assertEquals(100, workerMaxValue.getFatigue());
        assertEquals(100, workerMaxValue.getHungry());

        Worker workerNegative = new Worker(-1, -1, -1);
        assertEquals(0, workerNegative.getEnergy());
        assertEquals(0, workerNegative.getFatigue());
        assertEquals(0, workerNegative.getHungry());

        Worker workerOverflow = new Worker(101, 101, 101);
        assertEquals(100, workerOverflow.getEnergy());
        assertEquals(100, workerOverflow.getFatigue());
        assertEquals(100, workerOverflow.getHungry());
    }

    @Test
    public void testWorkerStatsSetters() {
        Worker worker = new Worker();

        worker.setEnergy(50);
        assertEquals(50, worker.getEnergy());

        worker.setFatigue(25);
        assertEquals(25, worker.getFatigue());

        worker.setHungry(75);
        assertEquals(75, worker.getHungry());
    }

    @Test
    public void testWorkerOneDay()
    {
        Worker worker = new Worker();
        assertEquals("working", worker.getState());

        worker.hourPassed();
        assertEquals("working", worker.getState());
        assertEquals(90, worker.getFatigue());
        assertEquals(85, worker.getEnergy());
        assertEquals(75, worker.getHungry());

        worker.hourPassed();
        assertEquals("working", worker.getState());
        assertEquals(80, worker.getFatigue());
        assertEquals(70, worker.getEnergy());
        assertEquals(50, worker.getHungry());

        worker.hourPassed();
        assertEquals("working", worker.getState());
        assertEquals(70, worker.getFatigue());
        assertEquals(55, worker.getEnergy());
        assertEquals(25, worker.getHungry());

        worker.hourPassed();
        assertEquals("eating", worker.getState());
        assertEquals(60, worker.getFatigue());
        assertEquals(40, worker.getEnergy());
        assertEquals(0, worker.getHungry());

        worker.hourPassed();
        assertEquals("eating", worker.getState());
        assertEquals(55, worker.getFatigue());
        assertEquals(40, worker.getEnergy());
        assertEquals(50, worker.getHungry());

        worker.hourPassed();
        assertEquals("working", worker.getState());
        assertEquals(50, worker.getFatigue());
        assertEquals(40, worker.getEnergy());
        assertEquals(100, worker.getHungry());

        worker.hourPassed();
        assertEquals("working", worker.getState());
        assertEquals(40, worker.getFatigue());
        assertEquals(25, worker.getEnergy());
        assertEquals(75, worker.getHungry());

        worker.hourPassed();
        assertEquals("working", worker.getState());
        assertEquals(30, worker.getFatigue());
        assertEquals(10, worker.getEnergy());
        assertEquals(50, worker.getHungry());

        worker.hourPassed();
        assertEquals("resting", worker.getState());
        assertEquals(20, worker.getFatigue());
        assertEquals(0, worker.getEnergy());
        assertEquals(25, worker.getHungry());

        worker.hourPassed();
        assertEquals("resting", worker.getState());
        assertEquals(15, worker.getFatigue());
        assertEquals(0, worker.getEnergy());
        assertEquals(10, worker.getHungry());

        worker.hourPassed();
        assertEquals("eating", worker.getState());
        assertEquals(10, worker.getFatigue());
        assertEquals(0, worker.getEnergy());
        assertEquals(0, worker.getHungry());

        worker.hourPassed();
        assertEquals("eating", worker.getState());
        assertEquals(5, worker.getFatigue());
        assertEquals(0, worker.getEnergy());
        assertEquals(50, worker.getHungry());

        worker.hourPassed();
        assertEquals("sleeping", worker.getState());
        assertEquals(0, worker.getFatigue());
        assertEquals(0, worker.getEnergy());
        assertEquals(100, worker.getHungry());

        worker.hourPassed();
        assertEquals("sleeping", worker.getState());
        assertEquals(35, worker.getFatigue());
        assertEquals(35, worker.getEnergy());
        assertEquals(95, worker.getHungry());

        worker.hourPassed();
        assertEquals("sleeping", worker.getState());
        assertEquals(70, worker.getFatigue());
        assertEquals(70, worker.getEnergy());
        assertEquals(90, worker.getHungry());

        worker.hourPassed();
        assertEquals("working", worker.getState());
        assertEquals(100, worker.getFatigue());
        assertEquals(100, worker.getEnergy());
        assertEquals(85, worker.getHungry());
    }

    @Test
    public void testSetState()
    {
        Worker worker = new Worker();
        worker.setState(new EatingState(worker));

        assertEquals("eating", worker.getState());
    }
}
