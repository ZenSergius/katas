package patterns.state.worker;

import patterns.state.worker.states.WorkerState;
import patterns.state.worker.states.WorkingState;

public class Worker {
    private int fatigue;
    private int hungry;
    private int energy;

    private WorkerState state;

    public Worker() {
        this(100, 100, 100);
    }

    public Worker(int energy, int fatigue, int hungry) {
        setEnergy(energy);
        setFatigue(fatigue);
        setHungry(hungry);
        setState(new WorkingState(this));
    }

    public int getFatigue() {
        return this.fatigue;
    }

    public int getHungry() {
        return hungry;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = sanitizeValue(energy);
    }

    public void setFatigue(int fatigue) {
        this.fatigue = sanitizeValue(fatigue);
    }

    public void setHungry(int hungry) {
        this.hungry = sanitizeValue(hungry);
    }

    private int sanitizeValue(int value) {
        int sanitizedValue;

        if (value < 0) {
            sanitizedValue = 0;
        } else if (value > 100) {
            sanitizedValue = 100;
        } else {
            sanitizedValue = value;
        }

        return sanitizedValue;
    }

    public String getState() {
        return state.getState();
    }

    public void setState(WorkerState state) {
        this.state = state;
    }

    public void hourPassed() {
        this.state.afterOneHour();
    }
}
