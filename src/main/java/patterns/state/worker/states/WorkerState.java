package patterns.state.worker.states;

import patterns.state.worker.Worker;

abstract public class WorkerState {

    protected Worker worker;

    public WorkerState(Worker worker) {
        this.worker = worker;
    }

    abstract public String getState();
    abstract public void afterOneHour();

    protected boolean setPrimaryState() {
        if (worker.getHungry() == 0) {
            worker.setState(new EatingState(worker));
        } else if (worker.getFatigue() == 0) {
            worker.setState(new SleepingState(worker));
        } else if (worker.getEnergy() == 0) {
            worker.setState(new RestingState(worker));
        } else {
            return false;
        }

        return true;
    }
}
